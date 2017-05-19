package com.senyint.queue.rabbitmq.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "queue.mq")
public class RabbitMQBean {
    private List<Map<String, String>> binds;
    private List<Map<String, String>> consumer;

    public List<Map<String, String>> getConsumer() {
        return consumer;
    }

    public void setConsumer(List<Map<String, String>> consumer) {
        this.consumer = consumer;
    }

    public List<Map<String, String>> getBinds() {
        return binds;
    }

    public void setBinds(List<Map<String, String>> binds) {
        this.binds = binds;
    }

}