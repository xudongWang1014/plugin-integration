package com.wangxd.example.plugin.integration.service.config.rabbitMQ;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 广播交换机配置
 */
@Component
public class FanoutConfig {

    /**
     * 邮件队列
     */
    private String FANOUT_EMAIL_QUEUE = "fanout_eamil_queue";
    /**
     * 短信队列
     */
    private String FANOUT_SMS_QUEUE = "fanout_sms_queue";
    /**
     * 短信队列
     */
    private String EXCHANGE_NAME = "fanoutExchange";


    /**
     * 邮件队列
     * @return
     */
    @Bean
    public Queue fanoutEmailQueue() {
        return new Queue(FANOUT_EMAIL_QUEUE);
    }

    /**
     * 短信队列
     * @return
     */
    @Bean
    public Queue fanoutSMSQueue() {
        return new Queue(FANOUT_SMS_QUEUE);
    }

    /**
     * 定义交换机
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE_NAME);
    }

    /**
     *  邮件队列和交换机绑定      参数名称和定义好的方法名称一致
     * @param fanoutEmailQueue
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingExchangeEamil(Queue fanoutEmailQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutEmailQueue).to(fanoutExchange);
    }

    /**
     * 短信队列和交换机绑定
     * @param fanoutSMSQueue
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingExchangeSMS(Queue fanoutSMSQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutSMSQueue).to(fanoutExchange);
    }



}
