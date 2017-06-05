package com.senyint.queue.consumer;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

/**
 * @Title Receive
 * @Version 1.0
 * @Date 20170517 23:29:18
 * @Author hpym365 @gmail.com
 * @Description
 */
@Component
public class Receive implements ChannelAwareMessageListener {

    public AtomicInteger count = new AtomicInteger(1);

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        System.out.println("这个消息是本server处理的第" + count.getAndIncrement() + "个");

        byte[] body = message.getBody();
        String bodystr = new String(body, "UTF-8");

        Thread.sleep(5000);
        System.out.println("receiveMsg接受到的消息为:" + bodystr);
        // 消息消费确认ack
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
    }

}


//~ Formatted by Jindent --- http://www.jindent.com
