package com.example.springboot.kafka;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

public class CountIntercetor implements ProducerInterceptor<String, String> {

    int successCount = 0;
    int errorCount = 0;

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        if (e == null) {
            successCount++;
        } else {
            errorCount++;
        }
    }

    @Override
    public void close() {
        System.out.println("发送成功条数: " + successCount);
        System.out.println("发送失败条数：" + errorCount);

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
