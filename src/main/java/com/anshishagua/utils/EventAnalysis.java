package com.anshishagua.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.anshishagua.object.Event;
import com.anshishagua.object.Events;
import com.anshishagua.object.KafkaWriter;
import com.anshishagua.object.Record;
import com.anshishagua.object.StreamState;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.api.java.function.MapGroupsWithStateFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.ForeachWriter;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.api.java.UDF2;
import org.apache.spark.sql.streaming.GroupState;
import org.apache.spark.sql.streaming.GroupStateTimeout;
import org.apache.spark.sql.streaming.OutputMode;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.types.DataTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class EventAnalysis {
    private static final Logger LOG = LoggerFactory.getLogger(EventAnalysis.class);

    public static void main(String [] args) throws Exception {
        LOG.warn("Hello,world");

        SparkConf conf = new SparkConf();
        conf.setAppName("user-analyze");
        conf.setMaster("local[*]");

        conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
        conf.registerKryoClasses(new Class<?> [] {KafkaProducer.class});
        SparkSession spark = SparkSession.builder().appName("user-analyze").master("local[*]").config(conf).getOrCreate();

        spark.sqlContext().udf().register("parse_json", new UDF2<String, String, String>() {
            public String call(String string, String field) {
                JSONObject jsonObject = JSON.parseObject(string);

                return jsonObject.getString(field);
            }
        }, DataTypes.StringType);
        Dataset<Row> dataset = spark.readStream().format("kafka")
                .option("kafka.bootstrap.servers", "localhost:9092")
                .option("subscribe", "user-logs")
                .load()
                .selectExpr("CAST(value AS STRING) AS value");

        dataset = dataset.selectExpr(
                "cast(parse_json(value, 'id') as long) AS id",
                "cast(parse_json(value, 'money') as double) AS money",
                "cast(parse_json(value, 'timestamp') as long) AS timestamp",
                "cast(parse_json(value, 'ip') as string) AS ip",
                "value AS json");

        //id, money, timestamp, ip, json
        long threshold = 5 * 1000000;

        //count > 5
        MapGroupsWithStateFunction<String, Row, StreamState, Events> function = new MapGroupsWithStateFunction<String, Row, StreamState, Events>() {
            @Override
            public Events call(String key, Iterator<Row> values, GroupState<StreamState> state) throws Exception {
                Events events = new Events();

                while (values.hasNext()) {
                    Row row = values.next();

                    //id, money, timestamp, ip, json
                    long timestamp = row.getLong(2);

                    LOG.warn("timestamp:" + timestamp);

                    StreamState streamState = state.exists() ? state.get() : new StreamState();

                    List<Record> records = streamState.getRecords().stream().filter(record -> record.getTimestamp() >= (timestamp - threshold)).collect(Collectors.toList());

                    int count = records.size() + 1;
                    String json = row.getString(4);

                    if (count >= 5) {
                        List<String> triggeredRecords = records.stream().map(record -> record.getValue()).collect(Collectors.toList());
                        triggeredRecords.add(json);

                        Event event = new Event(timestamp, triggeredRecords);

                        streamState.setRecords(new ArrayList<>());
                        state.update(streamState);

                        events.addEvent(event);
                    } else {
                        records.add(new Record(timestamp, json));

                        streamState.setRecords(records);

                        state.update(streamState);
                    }
                }

                return events;
            }
        };

        //id, money, timestamp, ip
        Dataset<Events> eventsDataset = dataset.groupByKey(new MapFunction<Row, String>() {
            @Override
            public String call(Row value) {
                return value.get(0).toString();
            }
        }, Encoders.STRING()).mapGroupsWithState(function,
                Encoders.bean(StreamState.class),
                Encoders.bean(Events.class),
                GroupStateTimeout.ProcessingTimeTimeout());

        Dataset<Event> eventDataset = eventsDataset.flatMap(new FlatMapFunction<Events, Event>() {
            public Iterator<Event> call(Events events) {
                return events.getEvents().iterator();
            }
        }, Encoders.bean(Event.class));

        Dataset<String> events = eventDataset.map(new MapFunction<Event, String>() {
            @Override
            public String call(Event value) throws Exception {
                return JSON.toJSONString(value);
            }
        }, Encoders.STRING());

        //StreamingQuery query = events.writeStream().outputMode(OutputMode.Update()).format("console").start();

        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.ACKS_CONFIG, "1");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
        String topic = "event-logs";

        //KafkaWriter<String> kafkaWriter = new KafkaWriter<>(kafkaProducer, topic);

        StreamingQuery query = events.writeStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", "localhost:9092")
                .option("topic", topic)
                .option("checkpointLocation", "/tmp")
                .outputMode(OutputMode.Update())
                .start();

        query.awaitTermination();
    }
}