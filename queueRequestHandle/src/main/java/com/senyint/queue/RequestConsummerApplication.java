package com.senyint.queue;

import com.senyint.queue.consumer.Receive;
import com.senyint.queue.rabbitmq.utils.RabbitMQDAO;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by hp on 17-5-15.
 */
@SpringBootApplication
public class RequestConsummerApplication {

    @Autowired
    RabbitMQDAO dd;

    public static void main(String[] args) {
        SpringApplication.run(RequestConsummerApplication.class, args);

    }

}
