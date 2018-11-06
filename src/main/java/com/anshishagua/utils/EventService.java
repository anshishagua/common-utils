package com.anshishagua.utils;

import com.alibaba.fastjson.JSON;
import com.anshishagua.functions.ParseJson;
import com.anshishagua.object.Event;
import com.anshishagua.object.EventConfig;
import com.anshishagua.object.Events;
import com.anshishagua.object.Field;
import com.anshishagua.object.Fields;
import com.anshishagua.object.HostPort;
import com.anshishagua.object.KafkaDataSource;
import com.anshishagua.object.Record;
import com.anshishagua.object.SparkConfig;
import com.anshishagua.object.StreamState;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.api.java.function.MapGroupsWithStateFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.GroupState;
import org.apache.spark.sql.streaming.GroupStateTimeout;
import org.apache.spark.sql.streaming.OutputMode;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.types.StructType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * EventService.java
 *
 * @author lixiao
 * @date 2018-11-06
 */

public class EventService {
    private static final Logger LOG = LoggerFactory.getLogger(EventService.class);

    public static void analyze(EventConfig eventConfig) {
        SparkConfig sparkConfig = eventConfig.getSparkConfig();

        SparkConf conf = new SparkConf();
        conf.setAppName(sparkConfig.getAppName());
        conf.setMaster(sparkConfig.getMaster());

        Properties properties = sparkConfig.getProperties();

        for (Object object : properties.keySet()) {
            String key = (String) object;
            String value = properties.getProperty(key);

            conf.set(key, value);
        }

        SparkSession spark = SparkSession
                .builder()
                .appName(sparkConfig.getAppName())
                .master(sparkConfig.getMaster())
                .config(conf)
                .getOrCreate();

        SparkSqlUtils.registerUdfs(spark);

        KafkaDataSource dataSource = new KafkaDataSource();
        dataSource.setBootstrapServers(Arrays.asList(new HostPort("localhost", 9092)));
        dataSource.setTopic("user-logs");
        dataSource.setFields(Fields.newInstance(
                new Field("id", "long"),
                new Field("money", "double"),
                new Field("timestamp", "long", true),
                new Field("ip", "string")));

        String bootstrapServers = dataSource.getBootstrapServers().stream().map(it -> it.getHost() + ":" + it.getPort()).collect(Collectors.joining(","));
        Dataset<Row> dataset = spark.readStream().format("kafka")
                .option("kafka.bootstrap.servers", bootstrapServers)
                .option("subscribe", dataSource.getTopic())
                .load()
                .selectExpr("CAST(value AS STRING) AS value");

        List<String> selectExpressions = new ArrayList<>();

        for (Field field : dataSource.getFields().getFields()) {
            String expression = SparkSqlUtils.callFunction(ParseJson.FUNCTION_NAME, "value", "'" + field.getName() + "'");

            expression = SparkSqlUtils.cast(expression, field.getType(), field.getName());

            selectExpressions.add(expression);
        }

        selectExpressions.add("value as json");

        dataset = dataset.selectExpr(selectExpressions.toArray(new String[0]));

        dataset.printSchema();

        /*
        dataset = dataset.selectExpr(
                "cast(parse_json(value, 'id') as long) AS id",
                "cast(parse_json(value, 'money') as double) AS money",
                "cast(parse_json(value, 'timestamp') as long) AS timestamp",
                "cast(parse_json(value, 'ip') as string) AS ip",
                "value AS json");
        */

        //id, money, timestamp, ip, json
        long threshold = 5 * 1000000;

        StructType structType = dataset.schema();

        Field timestampField = getTimestampField(dataSource.getFields());

        String expression = "count() >= 5";

        //count > 5
        MapGroupsWithStateFunction<String, Row, StreamState, Events> function = new MapGroupsWithStateFunction<String, Row, StreamState, Events>() {
            @Override
            public Events call(String key, Iterator<Row> values, GroupState<StreamState> state) throws Exception {
                Events events = new Events();

                while (values.hasNext()) {
                    Row row = values.next();

                    //id, money, timestamp, ip, json
                    long timestamp = row.getLong(timestampField.getIndex());

                    LOG.warn("timestamp:" + timestamp);

                    StreamState streamState = state.exists() ? state.get() : new StreamState();

                    List<Row> rows = new ArrayList<>();

                    List<Record> records = streamState.getRecords().stream().filter(record -> record.getTimestamp() >= (timestamp - threshold)).collect(Collectors.toList());

                    int count = records.size() + 1;

                    //Field jsonField = dataSource.getFields().getField("json");
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
