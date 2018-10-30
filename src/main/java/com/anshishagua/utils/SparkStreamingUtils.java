package com.anshishagua.utils;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.LongType;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparkStreamingUtils {
    public static void main(String [] args) throws Exception {
        SparkSession spark = SparkSession.builder().appName("wordcount").master("local[*]").getOrCreate();

        spark.sparkContext().setLogLevel("WARN");
        Dataset<Row> lines = spark.readStream().format("kafka")
                .option("kafka.bootstrap.servers", "localhost:9092")
                .option("subscribe", "test").load();

        //lines.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)").stat();

        List<StructField> fields = new ArrayList<>();
        fields.add(DataTypes.createStructField("id", DataTypes.LongType, false));
        fields.add(DataTypes.createStructField("name", DataTypes.StringType, false));
        fields.add(DataTypes.createStructField("age", DataTypes.IntegerType, false));

        StructType structType = DataTypes.createStructType(fields);

        /*
        Dataset<Row> lines = spark.readStream()
                .option("sep", ",")
                .schema(structType)
                .csv("/Users/xiaoli/IdeaProjects/common-utils/src/main/resources/user_info/date=2018-09-10");
        */

        //lines.show();
        lines = lines.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)");
        lines.printSchema();
        lines.writeStream().
        StreamingQuery query = lines
                .writeStream().format("console").start();

        query.awaitTermination();
    }
}
