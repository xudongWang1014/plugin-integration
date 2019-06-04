package com.wangxd.example.plugin.integration.service.rabbitMQ.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutConsumer {

    @RabbitListener(queues = "fanout_eamil_queue")
    @RabbitHandler
    public void process1(String message) {
        System.out.println("queue:fanout.message1,message:" + message);
    }

    @RabbitListener(queues = "fanout_sms_queue")
    @RabbitHandler
    public void process2(String message) {
        System.out.println("queue:fanout.message2,message:" + message);
    }

}
