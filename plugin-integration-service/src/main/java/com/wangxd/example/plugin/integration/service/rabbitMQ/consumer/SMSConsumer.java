package com.wangxd.example.plugin.integration.service.rabbitMQ.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component  //注册到Spring 容器里面
@RabbitListener(queues="fanout_sms_queue")   //监听
public class SMSConsumer {

    @RabbitHandler  //表示接收消息
    public void process(String mString) {
        System.out.println("短信消费者获取生产者消息msg"+mString);
    }

}
