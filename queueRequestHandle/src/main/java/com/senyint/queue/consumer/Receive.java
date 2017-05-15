package com.senyint.queue.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by hp on 17-5-16.
 */
@Component
public class Receive implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        System.out.println("receiveMsg接受到的消息为:"+message);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }
}
