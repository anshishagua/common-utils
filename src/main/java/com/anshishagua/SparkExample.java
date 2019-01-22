package com.anshishagua;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.expressions.UserDefinedFunction;
import org.apache.spark.sql.functions;

import java.util.logging.Logger;

public class SparkExample {
    public static void main(String [] args) {
        Logger logger = Logger.getLogger("aaa");
        logger.warning("fff");

        SparkSession spark = SparkSession.builder().master("local[*]").appName("test").getOrCreate();

        UserDefinedFunction userDefinedFunction;
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("SparkExample");
        sparkConf.setMaster("yarn");
        SparkContext context = SparkContext.getOrCreate(sparkConf);

        System.out.println("hello, world");

        System.out.println(context.applicationId());

        Column column;

        functions.col("aaa[0]");
    }
}