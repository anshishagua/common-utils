package com.anshishagua.utils;

import org.apache.hadoop.yarn.api.ApplicationConstants;
import org.apache.spark.SparkConf;
import org.apache.spark.deploy.yarn.ApplicationMaster;
import org.apache.spark.deploy.yarn.YarnSparkHadoopUtil;

public class YarnClientUtils {
    public static void main(String [] args) {
        SparkConf sparkConf = new SparkConf();
        System.out.println(YarnSparkHadoopUtil.expandEnvironment(ApplicationConstants.Environment.PWD));
    }
}
