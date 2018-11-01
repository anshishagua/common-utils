package com.anshishagua.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.anshishagua.object.Event;
import com.anshishagua.object.Record;
import com.anshishagua.object.StreamState;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.api.java.function.MapGroupsWithStateFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.api.java.UDF2;
import org.apache.spark.sql.streaming.GroupState;
import org.apache.spark.sql.streaming.GroupStateTimeout;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.types.DataTypes;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class EventAnalysis {
    public static void main(String [] args) throws Exception {
        SparkSession spark = SparkSession.builder().appName("user-analyze").master("local[*]").getOrCreate();

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

        dataset = dataset.selectExpr("parse_json(value, 'id') AS id",
                "parse_json(value, 'money') AS money",
                "parse_json(value, 'timestamp') AS timestamp");

        long threadhold = 111111;

        MapGroupsWithStateFunction<String, Row, StreamState, Event> function = new MapGroupsWithStateFunction<String, Row, StreamState, Event>() {
            @Override
            public Event call(String key, Iterator<Row> values, GroupState<StreamState> state) throws Exception {
                List<Row> rows = new ArrayList<>();

                while (values.hasNext()) {
                    Row row = values.next();

                    Timestamp timestamp = (Timestamp) row.get(1);

                    List<Record> records = state.get().getRecords().stream().filter(record -> record.getTimestamp() >= (timestamp.getTime() - threadhold)).collect(Collectors.toList());

                }


                return new Event(1110L, new ArrayList<>());
            }
        };

        Dataset<Event> eventDataset = dataset.groupByKey(new MapFunction<Row, String>() {
            @Override
            public String call(Row value) {
                return value.getString(1);
            }
        }, Encoders.bean(String.class)).mapGroupsWithState(function,
                Encoders.bean(StreamState.class),
                Encoders.bean(Event.class),
                GroupStateTimeout.ProcessingTimeTimeout());

        StreamingQuery query = eventDataset.writeStream().format("console").start();

        query.awaitTermination();
    }
}
