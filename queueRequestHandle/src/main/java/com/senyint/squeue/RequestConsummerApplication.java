package com.senyint.squeue;

import com.senyint.squeue.rabbitmq.utils.RabbitMQDAO;
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
