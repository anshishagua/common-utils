package com.anshishagua;

import org.apache.pig.PigServer;
import org.apache.pig.newplan.logical.relational.LOLoad;
import org.apache.pig.scripting.Pig;
import org.apache.pig.tools.grunt.GruntParser;
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
    public static void main(String [] args) throws Exception {
        SpringApplication.run(Application.class, args);

        Pig pig = Pig.compile("aa");

        GruntParser parser;
        PigServer server;

        LOLoad loLoad;
    }
}
