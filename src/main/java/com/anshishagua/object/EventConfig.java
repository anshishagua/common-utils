package com.anshishagua.object;

/**
 * EventConfig.java
 *
 * @author lixiao
 * @date 2018-11-06
 */

public class EventConfig {
    private String name;
    private String triggerCondition;
    private SparkConfig sparkConfig;
    private KafkaDataSource kafkaDataSource;
    private KafkaDataSink kafkaDataSink;

    public EventConfig(String name, String triggerCondition, SparkConfig sparkConfig, KafkaDataSource kafkaDataSource, KafkaDataSink kafkaDataSink) {
        this.name = name;
        this.triggerCondition = triggerCondition;
        this.sparkConfig = sparkConfig;
        this.kafkaDataSource = kafkaDataSource;
        this.kafkaDataSink = kafkaDataSink;
    }

    public String getName() {
        return name;
    }

    public String getTriggerCondition() {
        return triggerCondition;
    }

    public SparkConfig getSparkConfig() {
        return sparkConfig;
    }

    public KafkaDataSource getKafkaDataSource() {
        return kafkaDataSource;
    }

    public KafkaDataSink getKafkaDataSink() {
        return kafkaDataSink;
    }
}
