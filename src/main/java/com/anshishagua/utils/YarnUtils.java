package com.anshishagua.utils;

import com.alibaba.fastjson.JSON;
import com.anshishagua.object.ApplicationIDCreateResponse;
import com.anshishagua.object.ApplicationStatus;
import org.apache.spark.deploy.Client;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * YarnUtils.java
 *
 * @author lixiao
 * @date 2018-10-21
 */

public class YarnUtils {
    private static final String YARN_URL = "http://localhost:8088/";

    public static String newApplicationId() {
        RestTemplate restTemplate = new RestTemplate();

        String json = restTemplate.postForObject(YARN_URL + "ws/v1/cluster/apps/new-application", null, String.class);

        ApplicationIDCreateResponse response = JSON.parseObject(json, ApplicationIDCreateResponse.class);

        return response.getApplicationId();
    }

    public static void submitApplication() {
        String url = YARN_URL + "ws/v1/cluster/apps";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        params.add("application-id", newApplicationId());
        params.add("application-name", "spark-pi");
        params.add("application-type", "yarn");
    }

    public static ApplicationStatus applicationStatus(String applicationId) {
        String url = YARN_URL + "ws/v1/cluster/apps/" + applicationId;

        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(url, String.class);

        json = JSON.parseObject(json).getString("app");

        return JSON.parseObject(json, ApplicationStatus.class);
    }

    public static void killApplication(String applicationId, String username) {
        String url = YARN_URL + "ws/v1/cluster/apps/" + applicationId + "/state";

        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);

        restTemplate.put(url, params);
    }

    public static void main(String [] args) {
        String applicationId = "application_1540136029583_0001";

        //System.out.println(applicationStatus(applicationId));

        applicationId = "application_1540136029583_0004";
        killApplication(applicationId, "lixiao");
    }
}