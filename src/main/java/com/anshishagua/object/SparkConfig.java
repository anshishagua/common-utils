package com.anshishagua.object;

import java.util.Properties;

/**
 * SparkConfig.java
 *
 * @author lixiao
 * @date 2018-11-06
 */

public class SparkConfig {
    private String appName;
    private String master;
    private Properties properties;

    public SparkConfig(String appName, String master) {
        this.appName = appName;
        this.master = master;
        this.properties = new Properties();
    }

    public void addProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public String getAppName() {
        return appName;
    }

    public String getMaster() {
        return master;
    }

    public Properties getProperties() {
        return properties;
    }
}
