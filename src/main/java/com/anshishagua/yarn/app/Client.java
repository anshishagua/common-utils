package com.anshishagua.yarn.app;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.yarn.api.ApplicationConstants;
import org.apache.hadoop.yarn.api.records.ApplicationId;
import org.apache.hadoop.yarn.api.records.ApplicationSubmissionContext;
import org.apache.hadoop.yarn.api.records.ContainerLaunchContext;
import org.apache.hadoop.yarn.api.records.LocalResource;
import org.apache.hadoop.yarn.api.records.LocalResourceType;
import org.apache.hadoop.yarn.api.records.LocalResourceVisibility;
import org.apache.hadoop.yarn.api.records.Priority;
import org.apache.hadoop.yarn.api.records.Resource;
import org.apache.hadoop.yarn.client.api.YarnClient;
import org.apache.hadoop.yarn.client.api.YarnClientApplication;
import org.apache.hadoop.yarn.client.api.async.AMRMClientAsync;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.apache.hadoop.yarn.util.ConverterUtils;
import org.apache.hadoop.yarn.util.Records;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    public static String submitApplication() throws Exception {
        Configuration configuration = new YarnConfiguration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000");
        configuration.set(YarnConfiguration.RM_WEBAPP_ADDRESS, "localhost:8088");

        YarnClient yarnClient = YarnClient.createYarnClient();
        yarnClient.init(configuration);
        yarnClient.start();

        YarnClientApplication yarnClientApplication = yarnClient.createApplication();
        ApplicationId applicationId = yarnClientApplication.getNewApplicationResponse().getApplicationId();
        ApplicationSubmissionContext context = yarnClientApplication.getApplicationSubmissionContext();

        context.setApplicationType("YARN");
        context.setMaxAppAttempts(3);
        context.setUnmanagedAM(false);
        context.setPriority(Priority.newInstance(1));
        context.setQueue("default");
        context.setApplicationId(applicationId);
        context.setApplicationName("example app");

        ContainerLaunchContext amContainer = Records.newRecord(ContainerLaunchContext.class);
        List<String> commands = new ArrayList<>();

        String appJar = "/tmp/apps/app.jar";
        String appClassName = "com.anshishagua.yarn.app.ApplicationMaster";

        String command = String.format("%s/bin/java -cp %s %s %s %s",
                ApplicationConstants.Environment.JAVA_HOME.$$(),
                appJar,
                appClassName,
                " 1>" + ApplicationConstants.LOG_DIR_EXPANSION_VAR + "/stdout",
                " 2>" + ApplicationConstants.LOG_DIR_EXPANSION_VAR + "/stderr");

        commands.add("echo $CLASSPATH;");
        //commands.add(command);
        System.out.println(command);
        amContainer.setCommands(commands);

        Map<String, String> environment = new HashMap<>();

        System.out.println(configuration.getStrings(YarnConfiguration.YARN_APPLICATION_CLASSPATH, null));
        StringBuilder classpath = new StringBuilder(ApplicationConstants.Environment.CLASSPATH.$$())
                .append(":").append("./*");
        for (String string : configuration.getStrings(YarnConfiguration.YARN_APPLICATION_CLASSPATH, YarnConfiguration.DEFAULT_YARN_APPLICATION_CLASSPATH)) {
            classpath.append(":");
            classpath.append(string.trim());
        }

        environment.put("CLASSPATH", classpath.toString());
        System.out.println(environment);
        amContainer.setEnvironment(environment);

        Map<String, LocalResource> localResourceMap = new HashMap<>();
        Path path = new Path(appJar);

        path = FileSystem.get(configuration).makeQualified(path);
        LocalResource resource = Records.newRecord(LocalResource.class);
        FileStatus fileStatus = FileSystem.get(configuration).getFileStatus(path);
        resource.setResource(ConverterUtils.getYarnUrlFromPath(path));
        resource.setSize(fileStatus.getLen());
        resource.setTimestamp(fileStatus.getModificationTime());
        resource.setType(LocalResourceType.FILE);
        resource.setVisibility(LocalResourceVisibility.APPLICATION);
        localResourceMap.put("aaaa", resource);

        path = new Path("/tmp/apps/hadoop-yarn-client-2.7.7.jar");
        path = FileSystem.get(configuration).makeQualified(path);
        resource = Records.newRecord(LocalResource.class);
        fileStatus = FileSystem.get(configuration).getFileStatus(path);
        resource.setResource(ConverterUtils.getYarnUrlFromPath(path));
        resource.setSize(fileStatus.getLen());
        resource.setTimestamp(fileStatus.getModificationTime());
        resource.setType(LocalResourceType.FILE);
        resource.setVisibility(LocalResourceVisibility.APPLICATION);
        localResourceMap.put("aabbbaa", resource);


        amContainer.setLocalResources(localResourceMap);
        context.setAMContainerSpec(amContainer);
        context.setResource(Resource.newInstance(256, 1));

        yarnClient.submitApplication(context);

        return applicationId.toString();
    }

    public static void main(String [] args) throws Exception {
        submitApplication();
    }
}
