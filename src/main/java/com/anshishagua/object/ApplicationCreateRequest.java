package com.anshishagua.object;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * ApplicationCreateRequest.java
 *
 * @author lixiao
 * @date 2018-10-21
 */

public class ApplicationCreateRequest {
    public static final String DEFAULT_QUEUE_NAME = "default";
    public static final String DEFAULT_APPLICATION_TYPE = "YARN";

    public static class ContainerSpec {

    }

    @JSONField(name = "application-id")
    private String applicationId;
    @JSONField(name = "application-name")
    private String applicaionName;
    private String queue = DEFAULT_QUEUE_NAME;

    @JSONField(name = "application-type")
    private String applicationType = DEFAULT_APPLICATION_TYPE;
}
