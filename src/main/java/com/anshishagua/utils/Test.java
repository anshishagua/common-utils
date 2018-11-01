package com.anshishagua.utils;

import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.deploy.PythonRunner;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;

public class Test {
    public static void main(String [] args) {
        SparkSession spark = SparkSession.builder().master("local[*]").appName("aa").getOrCreate();

        Dataset<Integer> dataset = spark.createDataset(Arrays.asList(1, 2, 3), Encoders.INT());

        dataset.printSchema();

        dataset.filter("value > 2").show();

        Dataset<Row> ddd = null;

        PythonRunner pythonRunner;
    }
}
