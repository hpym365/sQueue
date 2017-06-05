package com.senyint.queue.rabbitmq.utils;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hp on 17-5-17.
 */
@Component
public class RabbitMQDAO implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String exChange, String routingKey, Object msg, CorrelationData correlationId, RabbitTemplate.ConfirmCallback confirmCallback) {
        rabbitTemplate.setConfirmCallback(confirmCallback);//设置回调
        //消息发送到exchange
        rabbitTemplate.convertAndSend(exChange, routingKey, msg, correlationId);
    }

    public void sendMessage(String exChange, String routingKey, Object msg, CorrelationData correlationId) {
        rabbitTemplate.setConfirmCallback(this);//设置回调
        //消息发送到exchange
        rabbitTemplate.convertAndSend(exChange, routingKey, msg, correlationId);
    }

    public void sendMessage(String exChange, String routingKey, Object msg, RabbitTemplate.ConfirmCallback confirmCallback) {
        rabbitTemplate.setConfirmCallback(confirmCallback);//设置回调
        //消息发送到exchange
        rabbitTemplate.convertAndSend(exChange, routingKey, msg);
    }

    public void sendMessage(String exChange, String routingKey, Object msg) {
        rabbitTemplate.setConfirmCallback(this);//设置回调
        //消息发送到exchange
        rabbitTemplate.convertAndSend(exChange, routingKey, msg);
    }

    public void confirm(CorrelationData correlationData, boolean ack, String s) {
        System.out.println(" 回调id:" + correlationData);
        if (ack) {
            System.out.println("消息成功发送1");
        } else {
            System.out.println("消息发送失败:" + s + "\n重新发送");

        }
    }
}
