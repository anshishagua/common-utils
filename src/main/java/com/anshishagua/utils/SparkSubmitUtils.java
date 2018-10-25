package com.anshishagua.utils;

import com.anshishagua.object.SparkConstants;
import org.apache.spark.deploy.SparkSubmit;
import org.apache.spark.executor.CoarseGrainedExecutorBackend;

public class SparkSubmitUtils {
    public static void submit(String className, String jarPath, String appName) {
        SystemUtils.setEnv("HADOOP_CONF_DIR", System.getProperty("HADOOP_HOME") + "/etc");

        String[] args = new String[] {
                "--class", className,
                "--master", "yarn",
                "--name", appName,
                "--deploy-mode", "cluster",
                jarPath,
                "3"};

        SparkSubmit.main(args);
    }

    public static void main(String [] args) {
        SystemUtils.setEnv("HADOOP_CONF_DIR", System.getProperty("HADOOP_HOME") + "/etc");

        submit("com.anshishagua.SparkExample",
                "/Users/xiaoli/IdeaProjects/common-utils/target/common-utils-1.0-SNAPSHOT.jar",
                "aaaaaaaa");
    }

    public static void main2(String [] arguments) {
        SystemUtils.setEnv("HADOOP_CONF_DIR", System.getProperty("HADOOP_HOME") + "/etc");

        String[] args = new String[] {
                "--class", "org.apache.spark.examples.SparkPi",
                "--master", "yarn",
                "--name", "xxxwerqwerqwer",
                "--deploy-mode", "cluster",
                System.getenv("SPARK_HOME") + "/examples/jars/spark-examples_2.11-" + SparkConstants.SPARK_VERSION + ".jar",
                "3"};

        SparkSubmit.main(args);
    }
}
