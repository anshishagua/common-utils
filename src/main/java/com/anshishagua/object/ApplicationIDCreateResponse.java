package com.anshishagua.object;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * ApplicationIDCreateResponse.java
 *
 * @author lixiao
 * @date 2018-10-21
 */

public class ApplicationIDCreateResponse {
    @JSONField(name = "application-id")
    private String applicationId;

    public ApplicationIDCreateResponse() {

    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    @Override
    public String toString() {
        return "ApplicationIDCreateResponse{" +
                "applicationId='" + applicationId + '\'' +
                '}';
    }
}