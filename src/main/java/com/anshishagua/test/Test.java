package com.anshishagua.test;

import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.types.DataTypes;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;


public class Test {
    public static void main(String [] args) {
        TreeSet<String> set = new TreeSet<>();

        set.addAll(Arrays.asList(
                "java.util.*",
                "java.io.*",
                "org.apache.spark.sql.Dataset",
                "org.apache.spark.sql.Row",
                "org.apache.spark.sql.RowFactory"
        ));

        System.out.println(set.tailSet("org.apache.spark.sql.Ro"));
    }
}
