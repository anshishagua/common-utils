package com.anshishagua.utils;

import kafka.common.OffsetMetadata;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class KafkaConsumerUtils {
    public static void main(String [] args) {
        Properties properties = new Properties();

        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "test-group");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList("test"));

        ConsumerRecords<String, String> consumerRecords = null;

        while (true) {
            consumerRecords = consumer.poll(300);

            Map<TopicPartition, OffsetAndMetadata> map = new HashMap<>();

            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                String topic = consumerRecord.topic();
                String key = consumerRecord.key();
                String value = consumerRecord.value();

                System.out.println("Topic:" + topic + ",key:" + key + ",value:" + value);
                long offset = consumerRecord.offset();

                TopicPartition topicPartition = new TopicPartition(topic, consumerRecord.partition());
                OffsetAndMetadata offsetMetadata = new OffsetAndMetadata(offset, null);

                map.put(topicPartition, offsetMetadata);
            }

            System.out.println("commit sync:" + map);
            consumer.commitSync(map);
        }
    }
}
