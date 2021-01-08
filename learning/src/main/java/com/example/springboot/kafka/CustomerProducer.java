package com.example.springboot.kafka;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.Properties;

public class CustomerProducer {

    public static void main(String[] args) {

        // 配置信息
        Properties properties = new Properties();
        // kafka集群
        properties.put("bootstrap.servers", "192.168.189.1:9092");
        // 应答级别
        properties.put("acks", "all");
        // 重试次数
        properties.put("retries", "0");
        // 批量大小
        properties.put("batch.size", "16384");
        // 提交延时
        properties.put("linger.ms", 1);
        // 缓存
        properties.put("buffer.memory", "33554432");
        // KV序列化类
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // 自定义分区
        //properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, "");

        // 拦截器
        ArrayList<String> list = new ArrayList<>();
        list.add("com.example.springboot.controller.CountIntercetor");
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, list);

        // 创建生产者对象
        KafkaProducer<Object, Object> producer = new KafkaProducer<>(properties);

        for (int i = 0; i < 10; i++) {

            //producer.send(new ProducerRecord<Object, Object>("topicName", String.valueOf(i)));

            // 回调
            producer.send(new ProducerRecord<Object, Object>("topicName", String.valueOf(i)), (recordMetadata, e) -> {

                if (e != null) {
                    System.out.println(recordMetadata.partition() + " --- " + recordMetadata.offset());

                } else {
                    System.out.println("发送失败");

                }

            });
        }

        // 关闭资源
        producer.close();

    }

}
