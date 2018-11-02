package com.anshishagua.object;

import java.io.Serializable;
import java.util.List;

public class KafkaDataSource implements Serializable {
    private String topic;
    private List<HostPort> bootstrapServers;
    private Fields fields;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<HostPort> getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(List<HostPort> bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "KafkaDataSource{" +
                "topic='" + topic + '\'' +
                ", bootstrapServers=" + bootstrapServers +
                ", fields=" + fields +
                '}';
    }
}
