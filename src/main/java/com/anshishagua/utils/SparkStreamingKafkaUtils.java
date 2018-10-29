package com.anshishagua.utils;

import kafka.serializer.StringDecoder;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;
import scala.Tuple2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SparkStreamingKafkaUtils {
    /*
    public static void main(String [] args) {
        SparkConf sparkConf = new SparkConf().setAppName("SparkKafka").setMaster("local[*]");
        JavaStreamingContext javaStreamingContext = new JavaStreamingContext(sparkConf, Durations.seconds(1));

        Map<String, String> kafkaParams = new HashMap<>();
        kafkaParams.put("metadata.broker.list", "localhost:9092");

        Set<String> topics = new HashSet<>();
        topics.add("test");

        JavaPairDStream<String, String> pairDStream = KafkaUtils.createDirectStream(javaStreamingContext, String.class, String.class,
                StringDecoder.class, StringDecoder.class, kafkaParams, topics);

        JavaDStream<String> valueStream = pairDStream.map(new Function<Tuple2<String, String>, String>() {
            @Override
            public String call(Tuple2<String, String> tuple2) throws Exception {
                return tuple2._2();
            }
        });

        valueStream.print();

        javaStreamingContext.start();

        try {
            javaStreamingContext.awaitTermination();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    */
}
