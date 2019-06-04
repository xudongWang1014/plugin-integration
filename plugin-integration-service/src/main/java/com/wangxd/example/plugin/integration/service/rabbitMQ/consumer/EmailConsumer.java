package com.wangxd.example.plugin.integration.service.rabbitMQ.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 邮件消费者
 */
@Component  //注册到Spring 容器里面
public class EmailConsumer {

    @RabbitHandler  //表示接收消息
    @RabbitListener(queues="fanout_eamil_queue")   //监听
    public void process(String mString) {
        System.out.println("邮件消费者获取生产者消息msg"+mString);
    }
}
