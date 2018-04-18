package com.spring.kafka.service;


import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.concurrent.ListenableFuture;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuhongbing on 2018/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:producer.xml", "classpath:consumer.xml"})

@Service
public class ProducerService {

    @Resource
    KafkaTemplate<Integer, String> kafkaTemplate;


    public void sendMessage(String topic, String msg) {
        if (topic == null || topic.length() == 0) {
            topic = kafkaTemplate.getDefaultTopic();
        }
        //kafkaTemplate.sendDefault(msg);
        kafkaTemplate.send(topic,0,Integer.valueOf("123456"),msg);
        //kafkaTemplate.send(topic,0,"hello");
    }

    @Test
    public void test() {
        try {
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sendMessage(null, s.format(new Date()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
