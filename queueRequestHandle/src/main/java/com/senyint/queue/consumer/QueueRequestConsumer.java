package com.senyint.queue.consumer;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * Created by hp on 17-5-15.
 */
//@Service
//@RabbitListener(queues = "recive_queue")
//public class QueueRequestConsumer {
//
////    @RabbitHandler
//    public void process(@Payload String msg){
//        System.out.println("接受到的消息为:"+msg);
//    }
//
//
//
//}
