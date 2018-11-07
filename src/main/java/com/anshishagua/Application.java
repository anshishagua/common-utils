package com.anshishagua;

import org.apache.spark.HashPartitioner;
import org.apache.spark.SparkConf;
import org.apache.spark.rdd.RDD;
import org.apache.spark.scheduler.TaskSchedulerImpl;
import org.apache.spark.shuffle.ShuffleManager;
import org.apache.spark.sql.Dataset;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String [] args) {
        SpringApplication.run(Application.class, args);

        RDD rdd;
        SparkConf conf;
        HashPartitioner hashPartitioner;

        TaskSchedulerImpl taskScheduler;

        Dataset dataset;
    }
}
