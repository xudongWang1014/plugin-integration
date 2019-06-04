package com.wangxd.example.plugin.integration.service.rabbitMQ.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生产者 ---  广播类型
 */
@Component
public class FanoutProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String queueName) {
        System.out.println("queueName"+queueName);
        String mString = "msg";
        amqpTemplate.convertAndSend(queueName,mString);  //发送消息
    }
}
