package com.senyint.queue.ctrl;

import com.senyint.queue.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Created by hp on 17-5-15.
 */
@RestController
public class HttpReciveController implements RabbitTemplate.ConfirmCallback{

    Logger logger = Logger.getLogger(HttpReciveController.class.getName());


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @RequestMapping(value = "/recive", method = RequestMethod.GET)
    public String test() {
        CorrelationData correlationId = new CorrelationData("123123");
        String json ="{\"name\":zhangsan,\"age\":20}";
        //消息发送到exchange
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE,RabbitMQConfig.ROUTING_KEY,json,correlationId);
        rabbitTemplate.setConfirmCallback(this);
        return "test";
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String s) {
        System.out.println(" 回调id:" + correlationData);
        if (ack) {
            System.out.println("消息成功发送");
        } else {
            System.out.println("消息发送失败:" + s+"\n重新发送");

        }
    }
}
