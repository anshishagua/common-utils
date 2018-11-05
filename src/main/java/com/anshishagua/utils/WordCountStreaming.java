package com.anshishagua.utils;

import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.OutputMode;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.sql.streaming.StreamingQueryListener;
import scala.Tuple2;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WordCountStreaming {
    public static void main(String [] args) throws Exception {
        SparkSession spark = SparkSession
                .builder()
                .appName("wordcount")
                .master("local[*]")
                .getOrCreate();

        spark.streams().addListener(new StreamingQueryListener() {
            @Override
            public void onQueryStarted(QueryStartedEvent event) {
                System.out.println("Query started:" + event);
            }

            @Override
            public void onQueryProgress(QueryProgressEvent event) {
                System.out.println("Query progress:" + event);
            }

            @Override
            public void onQueryTerminated(QueryTerminatedEvent event) {
                System.out.println("Query terminated:" + event);
            }
        });

        Dataset<Row> lines = spark.readStream()
                .format("socket")
                .option("host", "localhost")
                .option("port", 9999)
                .option("includeTimestamp", true)
                .load();

        lines.printSchema();

        Dataset<Row> words = lines
                .as(Encoders.tuple(Encoders.STRING(), Encoders.TIMESTAMP()))
                .flatMap(new FlatMapFunction<Tuple2<String, Timestamp>, Tuple2<String, Timestamp>>() {
                    @Override
                    public Iterator<Tuple2<String, Timestamp>> call(Tuple2<String, Timestamp> tuple2) throws Exception {
                        List<Tuple2<String, Timestamp>> result = new ArrayList<>();

                        for (String word : tuple2._1().split(" ")) {
                            result.add(new Tuple2<>(word, tuple2._2()));
                        }

                        return result.iterator();
                    }
                }, Encoders.tuple(Encoders.STRING(), Encoders.TIMESTAMP()))
                .toDF("word", "timestamp");

        Dataset<Row> windowedCounts = words
                .groupBy(functions.window(words.col("timestamp"), "1 seconds", "1 seconds")
                , words.col("word"))
                .count();

        windowedCounts.printSchema();

        StreamingQuery query = windowedCounts
                .writeStream()
                .format("console")
                .option("truncate", false)
                .outputMode(OutputMode.Update())
                .start();

        System.out.println(query.name());
        System.out.println(query.id());
        System.out.println(query.runId());
        System.out.println(query.status());
        System.out.println(query.lastProgress());

        try {
            query.awaitTermination();
        } catch (StreamingQueryException ex) {
            ex.printStackTrace();
        }
    }
}
