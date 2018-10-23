package com.anshishagua.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.spark.SparkConf;
import org.apache.spark.deploy.SparkSubmit;
import org.apache.spark.deploy.yarn.ApplicationMaster;
import org.apache.spark.deploy.yarn.Client;
import org.apache.spark.deploy.yarn.ClientArguments;

public class SparkSubmitUtils {
    public static void main(String [] arguments) {
        System.out.println(System.getenv());
        SystemUtils.setEnv("name", "benben");

        System.out.println(System.getenv("name"));
        SystemUtils.setEnv("HADOOP_CONF_DIR", System.getProperty("HADOOP_HOME") + "/etc");


        String[] args = new String[] {
                "--class", "org.apache.spark.examples.SparkPi",
                "--master", "yarn",
                "--deploy-mode", "cluster",
                System.getenv("SPARK_HOME") + "/examples/jars/spark-examples_2.11-2.0.2.jar",

                "--arg", "3", "--arg", "yarn-cluster"};

        Configuration configuration = new Configuration();
        System.setProperty("SPARK_YARN_MODE", "true");
        configuration.set("fs.defaultFS", "hdfs://host:port");
        configuration.set("mapreduce.jobtracker.address", "host:port");
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("example");

        //ClientArguments cArgs = new ClientArguments(args);  // getting constructor error
        //Client client = new Client(cArgs, config, sparkConf); // getting constructor error
        //client.run();

        SparkSubmit.main(args);
    }
}
