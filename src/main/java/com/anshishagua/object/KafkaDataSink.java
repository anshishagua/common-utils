package com.anshishagua.object;

import java.util.List;
import java.util.Properties;

public class KafkaDataSink {
    private final String topic;
    private final List<HostPort> bootstrapServers;
    private Properties properties;

    public KafkaDataSink(String topic, List<HostPort> bootstrapServers) {
        this.topic = topic;
        this.bootstrapServers = bootstrapServers;
        this.properties = new Properties();
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void addProperty(String key, String value) {
        this.properties.setProperty(key, value);
    }

    public String getTopic() {
        return topic;
    }

    public List<HostPort> getBootstrapServers() {
        return bootstrapServers;
    }
}
