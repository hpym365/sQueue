package com.senyint.queue.config;

import com.rabbitmq.client.Channel;
import com.senyint.queue.consumer.Receive;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by hp on 17-5-15.
 */
@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "recive_exchange";

    public static final String ROUTING_KEY = "recive_key";



    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("127.0.0.1", 5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(EXCHANGE, true, false);
    }

    /**
     * 针对消费者配置
     *
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue("recive_queue", true); //队列持久
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(defaultExchange()).with(RabbitMQConfig.ROUTING_KEY);
    }


    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             ChannelAwareMessageListener listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("recive_queue");
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setMessageListener(listenerAdapter);
        return container;
    }

//    @Bean
//    MessageListenerAdapter listenerAdapter(Receive receiver) {
//        return new MessageListenerAdapter(receiver, "receiveMsg");
//    }

//    @Bean
//    ChannelAwareMessageListener jjj(){
//        return new Receive();
//    }

}
