package com.anshishagua.test;

import org.apache.spark.sql.SparkSession;

public class SparkTest {
    public static void main(String [] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("eeee")
                .master("yarn")
                .getOrCreate();

        System.out.println("hello,world");
    }
}
