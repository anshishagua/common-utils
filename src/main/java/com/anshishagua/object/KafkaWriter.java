package com.anshishagua.object;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.spark.sql.ForeachWriter;

import java.io.Serializable;

public class KafkaWriter<T> extends ForeachWriter<T> implements Serializable {
    public KafkaWriter(KafkaProducer<String, String> producer, String topic) {
        this.producer = producer;
        this.topic = topic;
    }

    private KafkaProducer<String, String> producer;
    private String topic;

    @Override
    public void process(T value) {
        String jsonValue = JSON.toJSONString(value);

        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, jsonValue);

        producer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (e != null) {
                    //LOG.warn("Failed to send {}", jsonValue, e);
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void close(Throwable errorOrNull) {

    }

    @Override
    public boolean open(long partitionId, long version) {
        return true;
    }
}

