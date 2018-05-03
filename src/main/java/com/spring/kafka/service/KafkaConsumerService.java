package com.spring.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;


/**
 * Created by liuhongbing on 2018/4/18.
 */

public class KafkaConsumerService implements MessageListener<Integer, String> {

    @Override
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) {
        System.out.println("Kafka开始消费。。。。。");
        System.out.println("key:" + consumerRecord.key());
        System.out.println("value:" + consumerRecord.value());
        System.out.println("offset：" + consumerRecord.offset());
        System.out.println("topic：" + consumerRecord.topic());
        System.out.println("partition：" + consumerRecord.partition());


        System.out.println("consumerRecord:"+consumerRecord.toString());
        System.out.println("Kafka结束消费。。。。。");
    }
}
