package com.anshishagua.utils;

import com.alibaba.fastjson.JSON;
import com.anshishagua.object.UserLog;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserLogUtils {
    public static void main(String [] args) throws Exception {
        Properties properties = new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.ACKS_CONFIG, "1");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        String topic = "user-logs";

        while (true) {
            String value = JSON.toJSONString(UserLog.random());

            System.out.println(value);

            RecordMetadata metadata =  producer.send(new ProducerRecord<>(topic, value)).get();
            System.out.println(metadata.offset());
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(3));
            } catch (Exception ex) {

            }
        }
    }
}
