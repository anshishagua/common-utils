package com.anshishagua.service;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.yarn.api.records.ApplicationId;
import org.apache.spark.SparkConf;
import org.apache.spark.deploy.SparkSubmit;
import org.apache.spark.deploy.yarn.Client;
import org.apache.spark.deploy.yarn.ClientArguments;

public class YarnService {
    public static void main(String [] args) {
        String [] arguments = {
                "--jar",
                "/Users/xiaoli/IdeaProjects/common-utils/target/common-utils-1.0.jar",
                "--class",
                "com.anshishagua.test.SparkTest"};

        ClientArguments clientArguments = new ClientArguments(arguments);

        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("yarn-client");
        sparkConf.setAppName("aaaa");

        Configuration config = new Configuration();

        Client client = new Client(clientArguments, sparkConf);

        //System.setProperty("SPARK_YARN_MODE", "true");

        client.run();

        //System.out.println(applicationId.toString());
    }
}
