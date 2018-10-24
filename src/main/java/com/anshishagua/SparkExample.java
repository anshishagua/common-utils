package com.anshishagua;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;

public class SparkExample {
    public static void main(String [] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("SparkExample");
        sparkConf.setMaster("yarn");
        SparkContext context = SparkContext.getOrCreate(sparkConf);

        System.out.println("hello, world");

        System.out.println(context.applicationId());
    }
}