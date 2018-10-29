package com.anshishagua.utils;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import java.util.Arrays;

public class SparkStreamingUtils {
    public static void main(String [] args) throws Exception {
        SparkSession spark = SparkSession.builder().appName("wordcount").master("local[*]").getOrCreate();

        Dataset<Row> lines = spark.readStream().format("kafka")
                .option("kafka.bootstrap.servers", "localhost:9092")
                .option("subscribe", "test").load();

        //lines.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)").stat();

        //lines.show();
        StreamingQuery query = lines.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
                .writeStream().format("console").start();

        query.awaitTermination();
    }
}
