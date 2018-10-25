package com.anshishagua.utils;

import com.alibaba.fastjson.JSON;
import com.anshishagua.object.ApplicationIDCreateResponse;
import com.anshishagua.object.ApplicationStatus;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.hadoop.util.ClassUtil;
import org.apache.hadoop.yarn.api.ApplicationConstants;
import org.apache.hadoop.yarn.api.records.ApplicationId;
import org.apache.hadoop.yarn.api.records.ApplicationReport;
import org.apache.hadoop.yarn.api.records.ApplicationSubmissionContext;
import org.apache.hadoop.yarn.api.records.ContainerLaunchContext;
import org.apache.hadoop.yarn.api.records.LocalResource;
import org.apache.hadoop.yarn.api.records.LocalResourceType;
import org.apache.hadoop.yarn.api.records.LocalResourceVisibility;
import org.apache.hadoop.yarn.api.records.Priority;
import org.apache.hadoop.yarn.api.records.Resource;
import org.apache.hadoop.yarn.api.records.YarnApplicationState;
import org.apache.hadoop.yarn.api.records.impl.pb.ContainerLaunchContextPBImpl;
import org.apache.hadoop.yarn.client.api.YarnClient;
import org.apache.hadoop.yarn.client.api.YarnClientApplication;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.apache.hadoop.yarn.util.Apps;
import org.apache.hadoop.yarn.util.ConverterUtils;
import org.apache.hadoop.yarn.util.Records;
import org.apache.spark.deploy.master.ApplicationState;
import org.apache.spark.deploy.yarn.ApplicationMaster;
import org.apache.spark.deploy.yarn.Client;
import org.apache.spark.deploy.SparkSubmit;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * YarnUtils.java
 *
 * @author lixiao
 * @date 2018-10-21
 */

public class YarnUtils {
    private static final String YARN_URL = "http://localhost:8088/";
    public static final String NEW_APPLICATION_ENDPOINT = "ws/v1/cluster/apps/new-application";
    public static final String SUBMIT_APPLICATION_ENDPOINT = "ws/v1/cluster/apps";
    public static final String APPLICATION_STATE_ENDPOINT = "ws/v1/cluster/apps/%s";
    public static final String KILL_APPLICATION_ENDPOINT = "ws/v1/cluster/apps/%s/state";

    private static String buildRequestUrl(String yarnHost, int yarnPort, String endpoint, String ... params) {
        if (endpoint.startsWith("/")) {
            endpoint = endpoint.substring(1);
        }

        if (params != null && params.length > 0) {
            return String.format(String.format("http://%s:%d/%s", yarnHost, yarnPort, endpoint), params);
        } else {
            return String.format("http://%s:%d/%s", yarnHost, yarnPort, endpoint);
        }
    }

    private static String buildRequestUrl(String yarnHost, int yarnPort, String endpoint) {
        return buildRequestUrl(yarnHost, yarnPort, endpoint, null);
    }

    public static String newApplicationId(String yarnHost, int yarnPort) {
        RestTemplate restTemplate = new RestTemplate();

        String url = buildRequestUrl(yarnHost, yarnPort, NEW_APPLICATION_ENDPOINT);
        String json = restTemplate.postForObject(url, null, String.class);

        ApplicationIDCreateResponse response = JSON.parseObject(json, ApplicationIDCreateResponse.class);

        return response.getApplicationId();
    }

    public static ApplicationStatus applicationStatus(String yarnHost, int yarnPort, String applicationId) {
        String url = String.format(buildRequestUrl(yarnHost, yarnPort, APPLICATION_STATE_ENDPOINT), applicationId);

        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(url, String.class);

        System.out.println(json);
        json = JSON.parseObject(json).getString("app");

        return JSON.parseObject(json, ApplicationStatus.class);
    }

    public static void killApplication(String yarnHost, int yarnPort, String applicationId, String username) {
        String url = buildRequestUrl(yarnHost, yarnPort, KILL_APPLICATION_ENDPOINT);
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);
        params.add("state", ApplicationStatus.FinalStatus.KILLED.toString());

        restTemplate.put(url, params);
    }

    private static ApplicationId parseApplicationId(String applicationId) {
        String [] fields = applicationId.split("_");

        return ApplicationId.newInstance(Long.parseLong(fields[1]), Integer.parseInt(fields[2]));
    }

    private static void addToLocalResources(FileSystem fs, String fileSrcPath,
                                            String fileDstPath, String appId,
                                            Map<String, LocalResource> localResources)
            throws IllegalArgumentException, IOException {
        String suffix = "mytest" + "/" + appId + "/" + fileDstPath;
        Path dst = new Path(fs.getHomeDirectory(), suffix);
        fs.copyFromLocalFile(new Path(fileSrcPath), dst);
        FileStatus scFileStatus = fs.getFileStatus(dst);
        LocalResource scRsrc = LocalResource.newInstance(
                ConverterUtils.getYarnUrlFromPath(dst), LocalResourceType.FILE,
                LocalResourceVisibility.APPLICATION, scFileStatus.getLen(),
                scFileStatus.getModificationTime());

        localResources.put(fileDstPath, scRsrc);
    }

    public static ApplicationId submitApplication(String yarnHost, int yarnPort, String applicationName, String jarPath, String className, String appMasterClassName) throws Exception {
        YarnClient yarnClient = YarnClient.createYarnClient();
        Configuration conf = new YarnConfiguration();

        conf.set(YarnConfiguration.RM_WEBAPP_ADDRESS, yarnHost + ":" + yarnPort);
        conf.setBoolean(YarnConfiguration.YARN_MINICLUSTER_FIXED_PORTS,true);

        yarnClient.init(conf);
        yarnClient.start();

        YarnClientApplication yarnClientApplication = yarnClient.createApplication();

        String userHome = System.getenv("HOME");

        String applicationId = yarnClientApplication.getNewApplicationResponse().getApplicationId().toString();

        /*
        String dest = userHome + "/" + ".sparkStaging/" + applicationId + "/__spark_conf__.zip";
        SystemUtils.setEnv("SPARK_YARN_STAGING_DIR",userHome + "/.sparkStaging/" + applicationId);

        String command = "mkdir -p " + userHome + "/" + ".sparkStaging/" + applicationId;
        System.out.println(command);
        Runtime.getRuntime().exec(command).waitFor();
        command = "cp " + userHome + "/Desktop/__spark_conf__.zip " + dest;
        System.out.println(command);
        Runtime.getRuntime().exec(command).waitFor();
        */

        ApplicationSubmissionContext context = yarnClientApplication.getApplicationSubmissionContext();

        //set application name
        context.setApplicationName(applicationName);

        //set queue
        String queue = "default";
        context.setQueue(queue);

        //set priority
        Priority priority = Records.newRecord(Priority.class);
        priority.setPriority(0);
        context.setPriority(priority);

        //set am container
        ContainerLaunchContext amContainer = Records.newRecord(ContainerLaunchContext.class);
        Map<String, LocalResource> localResourceMap = new HashMap<>();
        LocalResource resource = Records.newRecord(LocalResource.class);

        Path path = new Path(jarPath);

        path = FileSystem.get(conf).makeQualified(path);
        FileStatus fileStatus = FileSystem.get(conf).getFileStatus(path);
        resource.setResource(ConverterUtils.getYarnUrlFromPath(path));
        resource.setSize(fileStatus.getLen());
        resource.setTimestamp(fileStatus.getModificationTime());
        resource.setType(LocalResourceType.FILE);
        resource.setVisibility(LocalResourceVisibility.APPLICATION);
        localResourceMap.put("__app__.jar", resource);

        /*
        path = new Path(System.getenv("HOME")+ "/Desktop/spark-libs.zip");
        path = FileSystem.get(conf).makeQualified(path);
        fileStatus = FileSystem.get(conf).getFileStatus(path);
        resource = Records.newRecord(LocalResource.class);
        resource.setResource(ConverterUtils.getYarnUrlFromPath(path));
        resource.setSize(fileStatus.getLen());
        resource.setTimestamp(fileStatus.getModificationTime());
        resource.setType(LocalResourceType.ARCHIVE);
        resource.setVisibility(LocalResourceVisibility.APPLICATION);
        localResourceMap.put("__spark_libs__", resource);
        */

        /*
        path = new Path(System.getenv("HOME") + "/Desktop/spark-conf.zip");
        path = FileSystem.get(conf).makeQualified(path);
        fileStatus = FileSystem.get(conf).getFileStatus(path);
        resource = Records.newRecord(LocalResource.class);
        resource.setResource(ConverterUtils.getYarnUrlFromPath(path));
        resource.setSize(fileStatus.getLen());
        resource.setTimestamp(fileStatus.getModificationTime());
        resource.setType(LocalResourceType.ARCHIVE);
        resource.setVisibility(LocalResourceVisibility.APPLICATION);
        localResourceMap.put("__spark_conf__", resource);
        */

        amContainer.setLocalResources(localResourceMap);
        List<String> commands =
                Collections.singletonList("$JAVA_HOME/bin/java -server -Xmx1024m -Djava.io.tmpdir=$PWD/tmp " +
                        "-Dspark.yarn.app.container.log.dir=<LOG_DIR> " +
                        appMasterClassName + " " +
                        "--class " +  "'" + className + "' " +
                        "--jar " + jarPath + " " +
                        //"--arg '3' " +
                        //"--properties-file $PWD/__spark_conf__/__spark_conf__.properties " +
                        "1> <LOG_DIR>/stdout 2> " +
                        "<LOG_DIR>/stderr");

        commands = Collections.singletonList("$JAVA_HOME/bin/java"
                + " -Xmx256M"
                + " " + appMasterClassName + " "
                + " 1>" + ApplicationConstants.LOG_DIR_EXPANSION_VAR + "/stdout"
                + " 2>" + ApplicationConstants.LOG_DIR_EXPANSION_VAR + "/stderr");
        System.out.println(commands.get(0));
        amContainer.setCommands(commands);

        Map<String, String> appMasterEnv = new HashMap<>();
        String classPathEnv = "./*";
        appMasterEnv.put("CLASSPATH", "$PWD:$PWD/__spark_conf__:$PWD/__spark_libs__/*:$HADOOP_CONF_DIR:$HADOOP_COMMON_HOME/share/hadoop/common/*:$HADOOP_COMMON_HOME/share/hadoop/common/lib/*:$HADOOP_HDFS_HOME/share/hadoop/hdfs/*:$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*:$HADOOP_YARN_HOME/share/hadoop/yarn/*:$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*:$HADOOP_MAPRED_HOME/share/hadoop/mapreduce/*:$HADOOP_MAPRED_HOME/share/hadoop/mapreduce/lib/*");

        String[] defaultYarnAppClasspath = conf.getStrings(YarnConfiguration.YARN_APPLICATION_CLASSPATH);
        System.out.println("*** YARN_APPLICATION_CLASSPATH: " +
                Arrays.asList(defaultYarnAppClasspath != null ? defaultYarnAppClasspath : new String[]{}));

        for (String c : conf.getStrings(
                YarnConfiguration.YARN_APPLICATION_CLASSPATH,
                YarnConfiguration.DEFAULT_YARN_APPLICATION_CLASSPATH)) {
            System.out.println("--> " + c);
            Apps.addToEnvironment(appMasterEnv, ApplicationConstants.Environment.CLASSPATH.name(),
                    c.trim());
        }

        System.out.println("*** APP MASTER ENV: " +appMasterEnv);
        appMasterEnv.put("SPARK_YARN_MODE", "true");
        appMasterEnv.put("SPARK_USER", UserGroupInformation.getCurrentUser().getShortUserName());

        amContainer.setEnvironment(appMasterEnv);


        context.setAMContainerSpec(amContainer);

        boolean isUnmanagedAM = false;
        context.setUnmanagedAM(isUnmanagedAM);

        boolean cancelTokensWhenComplete = false;
        context.setCancelTokensWhenComplete(cancelTokensWhenComplete);

        int maxAppAttempts = 3;
        context.setMaxAppAttempts(maxAppAttempts);

        String applicationType = "SPARK";
        context.setApplicationType(applicationType);

        context.setResource(Resource.newInstance(1000, 1));

        yarnClient.submitApplication(context);

        return context.getApplicationId();
    }

    public static void submitApplication() throws Exception {
        YarnClient yarnClient = YarnClient.createYarnClient();
        Configuration conf = new YarnConfiguration();

        conf.set(YarnConfiguration.RM_WEBAPP_ADDRESS, "localhost:8088");
        conf.setBoolean(YarnConfiguration.YARN_MINICLUSTER_FIXED_PORTS,true);

        yarnClient.init(conf);
        yarnClient.start();

        YarnClientApplication yarnClientApplication = yarnClient.createApplication();

        String userHome = System.getenv("HOME");

        String applicationId = yarnClientApplication.getNewApplicationResponse().getApplicationId().toString();
        String dest = userHome + "/" + ".sparkStaging/" + applicationId + "/__spark_conf__.zip";

        SystemUtils.setEnv("SPARK_YARN_STAGING_DIR",userHome + "/.sparkStaging/" + applicationId);

        String command = "mkdir -p " + userHome + "/" + ".sparkStaging/" + applicationId;
        System.out.println(command);
        Runtime.getRuntime().exec(command).waitFor();
        command = "cp " + userHome + "/Desktop/__spark_conf__.zip " + dest;
        System.out.println(command);
        Runtime.getRuntime().exec(command).waitFor();

        ApplicationSubmissionContext context = yarnClientApplication.getApplicationSubmissionContext();

        //set application name
        String applicationName = "example";
        context.setApplicationName(applicationName);

        //set queue
        String queue = "default";
        context.setQueue(queue);

        //set priority
        Priority priority = Records.newRecord(Priority.class);
        priority.setPriority(0);
        context.setPriority(priority);

        //set am container
        ContainerLaunchContext amContainer = Records.newRecord(ContainerLaunchContext.class);
        Map<String, LocalResource> localResourceMap = new HashMap<>();
        LocalResource resource = Records.newRecord(LocalResource.class);

        Path jarPath = new Path("/usr/local/spark/spark-2.0.2-bin-hadoop2.7/examples/jars/spark-examples_2.11-2.0.2.jar");

        jarPath = FileSystem.get(conf).makeQualified(jarPath);
        FileStatus fileStatus = FileSystem.get(conf).getFileStatus(jarPath);
        resource.setResource(ConverterUtils.getYarnUrlFromPath(jarPath));
        resource.setSize(fileStatus.getLen());
        resource.setTimestamp(fileStatus.getModificationTime());
        resource.setType(LocalResourceType.FILE);
        resource.setVisibility(LocalResourceVisibility.APPLICATION);
        localResourceMap.put("__app__.jar", resource);

        jarPath = new Path("/Users/xiaoli/Desktop/spark-libs.zip");
        jarPath = FileSystem.get(conf).makeQualified(jarPath);
        fileStatus = FileSystem.get(conf).getFileStatus(jarPath);
        LocalResource resource1 = Records.newRecord(LocalResource.class);
        resource1.setResource(ConverterUtils.getYarnUrlFromPath(jarPath));
        resource1.setSize(fileStatus.getLen());
        resource1.setTimestamp(fileStatus.getModificationTime());
        resource1.setType(LocalResourceType.ARCHIVE);
        resource1.setVisibility(LocalResourceVisibility.APPLICATION);
        localResourceMap.put("__spark_libs__", resource1);

        jarPath = new Path("/Users/xiaoli/Desktop/spark-conf.zip");
        jarPath = FileSystem.get(conf).makeQualified(jarPath);
        fileStatus = FileSystem.get(conf).getFileStatus(jarPath);
        resource1 = Records.newRecord(LocalResource.class);
        resource1.setResource(ConverterUtils.getYarnUrlFromPath(jarPath));
        resource1.setSize(fileStatus.getLen());
        resource1.setTimestamp(fileStatus.getModificationTime());
        resource1.setType(LocalResourceType.ARCHIVE);
        resource1.setVisibility(LocalResourceVisibility.APPLICATION);
        localResourceMap.put("__spark_conf__", resource1);

        amContainer.setLocalResources(localResourceMap);
        List<String> commands =
                Collections.singletonList("$JAVA_HOME/bin/java -server -Xmx1024m -Djava.io.tmpdir=$PWD/tmp " +
                "-Dspark.yarn.app.container.log.dir=<LOG_DIR> " +
                "org.apache.spark.deploy.yarn.ApplicationMaster " +
                "--class 'org.apache.spark.examples.SparkPi' " +
                "--jar file:/usr/local/spark/spark-2.0.2-bin-hadoop2.7/examples/jars/spark-examples_2.11-2.0.2.jar " +
                "--arg '3' " +
                "--properties-file $PWD/__spark_conf__/__spark_conf__.properties " +
                "1> <LOG_DIR>/stdout 2> " +
                "<LOG_DIR>/stderr");
        amContainer.setCommands(commands);


        Map<String, String> appMasterEnv = new HashMap<>();
        String classPathEnv = "./*";
        appMasterEnv.put("CLASSPATH", "$PWD:$PWD/__spark_conf__:$PWD/__spark_libs__/*:$HADOOP_CONF_DIR:$HADOOP_COMMON_HOME/share/hadoop/common/*:$HADOOP_COMMON_HOME/share/hadoop/common/lib/*:$HADOOP_HDFS_HOME/share/hadoop/hdfs/*:$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*:$HADOOP_YARN_HOME/share/hadoop/yarn/*:$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*:$HADOOP_MAPRED_HOME/share/hadoop/mapreduce/*:$HADOOP_MAPRED_HOME/share/hadoop/mapreduce/lib/*");

        String[] defaultYarnAppClasspath = conf.getStrings(YarnConfiguration.YARN_APPLICATION_CLASSPATH);
        System.out.println("*** YARN_APPLICATION_CLASSPATH: " +
                Arrays.asList(defaultYarnAppClasspath != null ? defaultYarnAppClasspath : new String[]{}));

        for (String c : conf.getStrings(
                YarnConfiguration.YARN_APPLICATION_CLASSPATH,
                YarnConfiguration.DEFAULT_YARN_APPLICATION_CLASSPATH)) {
            System.out.println("--> " + c);
            Apps.addToEnvironment(appMasterEnv, ApplicationConstants.Environment.CLASSPATH.name(),
                    c.trim());
        }

        System.out.println("*** APP MASTER ENV: " +appMasterEnv);
        appMasterEnv.put("SPARK_YARN_MODE", "true");
        appMasterEnv.put("SPARK_USER", UserGroupInformation.getCurrentUser().getShortUserName());

        amContainer.setEnvironment(appMasterEnv);

        context.setAMContainerSpec(amContainer);

        boolean isUnmanagedAM = false;
        context.setUnmanagedAM(isUnmanagedAM);

        boolean cancelTokensWhenComplete = false;
        context.setCancelTokensWhenComplete(cancelTokensWhenComplete);

        int maxAppAttempts = 3;
        context.setMaxAppAttempts(maxAppAttempts);

        String applicationType = "SPARK";
        context.setApplicationType(applicationType);

        context.setResource(Resource.newInstance(1000, 1));

        yarnClient.submitApplication(context);
    }

    public static YarnClient get(String yarnHost, int yarnPort) {

        YarnClient yarnClient = YarnClient.createYarnClient();
        Configuration conf = new Configuration();

        conf.set(YarnConfiguration.RM_WEBAPP_ADDRESS, yarnHost + ":" + yarnPort);
        conf.setBoolean(YarnConfiguration.YARN_MINICLUSTER_FIXED_PORTS,true);

        yarnClient.init(conf);
        yarnClient.start();

        return yarnClient;
    }

    public static void main(String [] args) throws Exception {
        String yarnHost = "localhost";
        int yarnPort = 8088;
        String applicationName = UUID.randomUUID().toString();
        String className = "com.anshishagua.SparkExample";
        String jarPath = System.getenv("HOME") + "/code/common-utils/target/common-utils-1.0-SNAPSHOT.jar";
        String appMasterClassName = "org.apache.spark.deploy.yarn.ApplicationMaster";

        ApplicationId applicationId = submitApplication(yarnHost, yarnPort, applicationName, jarPath, className, appMasterClassName);

        //submitApplication();
        /*
        YarnClient yarnClient = yarnClient(yarnHost, yarnPort);
        ApplicationReport report = null;

        YarnApplicationState state = null;

        do {
            report = yarnClient.getApplicationReport(applicationId);
            state = report.getYarnApplicationState();

            TimeUnit.SECONDS.sleep(5);

            System.out.println(state);
        } while (state != YarnApplicationState.FAILED && state != YarnApplicationState.FINISHED);

        System.out.println("Final status: " + report.getFinalApplicationStatus());
        */
    }
}