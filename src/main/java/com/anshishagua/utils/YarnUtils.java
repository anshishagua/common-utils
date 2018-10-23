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
import org.apache.hadoop.yarn.api.records.impl.pb.ContainerLaunchContextPBImpl;
import org.apache.hadoop.yarn.client.api.YarnClient;
import org.apache.hadoop.yarn.client.api.YarnClientApplication;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.apache.hadoop.yarn.util.ConverterUtils;
import org.apache.hadoop.yarn.util.Records;
import org.apache.spark.deploy.yarn.Client;
import org.apache.spark.deploy.SparkSubmit;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    public static void submitApplication(String yarnHost, int yarnPort) {
        String url = buildRequestUrl(yarnHost, yarnPort, SUBMIT_APPLICATION_ENDPOINT);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        params.add("application-id", newApplicationId(yarnHost, yarnPort));
        params.add("application-name", "spark-pi");
        params.add("application-type", "yarn");
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

    public static void submitApplication() throws Exception {
        YarnClient yarnClient = YarnClient.createYarnClient();
        Configuration conf = new YarnConfiguration();

        conf.set(YarnConfiguration.RM_WEBAPP_ADDRESS, "localhost:8088");
        conf.setBoolean(YarnConfiguration.YARN_MINICLUSTER_FIXED_PORTS,true);

        yarnClient.init(conf);
        yarnClient.start();

        YarnClientApplication yarnClientApplication = yarnClient.createApplication();
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
        List<String> commands = new ArrayList<>();
        amContainer.setCommands(commands);
                //createAMContainerLaunchContext(conf, yarnClientApplication.getNewApplicationResponse().getApplicationId());
        context.setAMContainerSpec(amContainer);

        boolean isUnmanagedAM = false;
        context.setUnmanagedAM(isUnmanagedAM);

        boolean cancelTokensWhenComplete = false;
        context.setCancelTokensWhenComplete(cancelTokensWhenComplete);

        int maxAppAttempts = 3;
        context.setMaxAppAttempts(maxAppAttempts);

        Resource resource = Resource.newInstance(1111, 1);
        context.setResource(resource);

        String applicationType = "SPARK";
        context.setApplicationType(applicationType);

        //yarnClient.submitApplication(context);
    }

    public static void main(String [] args) throws Exception {
        String applicationId = "application_1540192469362_0001";

        applicationId = "application_1540192469362_0001";
        String yarnHost = "localhost";
        int yarnPort = 8088;

        YarnClient yarnClient = YarnClient.createYarnClient();
        Configuration conf = new YarnConfiguration();

        conf.set(YarnConfiguration.RM_WEBAPP_ADDRESS, yarnHost + ":" + yarnPort);
        conf.setBoolean(YarnConfiguration.YARN_MINICLUSTER_FIXED_PORTS,true);

        yarnClient.init(conf);
        yarnClient.start();

        submitApplication();
    }
}