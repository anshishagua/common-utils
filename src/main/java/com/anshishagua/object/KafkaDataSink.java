package com.anshishagua.object;

import java.util.List;

public class KafkaDataSink {
    private final String topic;
    private final List<HostPort> bootstrapServers;

    public KafkaDataSink(String topic, List<HostPort> bootstrapServers) {
        this.topic = topic;
        this.bootstrapServers = bootstrapServers;
    }

    public String getTopic() {
        return topic;
    }

    public List<HostPort> getBootstrapServers() {
        return bootstrapServers;
    }
}
