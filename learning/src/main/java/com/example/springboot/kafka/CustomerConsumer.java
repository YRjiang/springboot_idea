package com.example.springboot.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class CustomerConsumer {

    public static void main(String[] args) {

        // 配置信息
        Properties props = new Properties();
        // kafka集群
        props.put("bootstrap.servers", "192.168.189.1:9092");
        // 消费者组id
        props.put("group.id", "test");
        // 设置自动提交 offset
        props.put("enable.auto.commit", "true");
        // 可能产生重复输出, 提交延时
        props.put("auto.commit.interval.ms", "1000");
        // KV 反序列化
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");

        // 创建消费者对象
        KafkaConsumer<Object, Object> consumer = new KafkaConsumer<>(props);

        // 指定 topic
        consumer.subscribe(Arrays.asList("topicName", "topicTest"));

        // 获取数据
        while (true) {
            ConsumerRecords<Object, Object> consumerRecords = consumer.poll(100);

            for (ConsumerRecord<Object, Object> record : consumerRecords) {
                System.out.println("kafka 打印接收数据: " + record.topic() + " --- "
                        + record.partition() + " --- "
                        + record.value() );
            }
        }

        
    }

}
