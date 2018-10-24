package com.anshishagua.utils;

import org.apache.hadoop.yarn.api.ApplicationConstants;
import org.apache.spark.SparkConf;
import org.apache.spark.deploy.yarn.ApplicationMaster;
import org.apache.spark.deploy.yarn.YarnSparkHadoopUtil;

import java.util.UUID;

public class YarnClientUtils {
    public static void main(String [] args) throws Exception {
        String yarnHost = "localhost";
        int yarnPort = 8088;
        String applicationName = UUID.randomUUID().toString();
        String className = "com.anshishagua.SparkExample";
        String jarPath = "/Users/xiaoli/IdeaProjects/common-utils/target/common-utils-1.0-SNAPSHOT.jar";
        String appMasterClassName = "com.anshishagua.yarn.ApplicationMaster";

        YarnUtils.submitApplication(yarnHost, yarnPort, applicationName, jarPath, className, appMasterClassName);
    }
}
