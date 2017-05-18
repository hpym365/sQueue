package com.senyint.queue.ctrl;

import com.senyint.queue.rabbitmq.utils.RabbitMQDAO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 * Created by hp on 17-5-15.
 */
@RestController
public class HttpReciveController implements RabbitTemplate.ConfirmCallback{

    Logger logger = Logger.getLogger(HttpReciveController.class.getName());

    @Autowired
    private RabbitMQDAO dao;

    public AtomicInteger count=new AtomicInteger(1);

    @RequestMapping(value = "/receive", method = RequestMethod.GET)
    public String test() {
        for(int i=0;i<10;i++){
            CorrelationData correlationId = new CorrelationData(""+count.getAndIncrement());

            String json ="{\"name\":zhangsan,\"age\":20}";

            dao.sendMessage("receive_exchange","receive_key",json,correlationId);
//            rabbitTemplate.setConfirmCallback(this);//设置回调
//            //消息发送到exchange
//            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE,RabbitMQConfig.ROUTING_KEY,json,correlationId);
        }
        System.out.println("此次coutnt1:"+count.get());
        return "test";
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String s) {
        System.out.println(" 回调id:" + correlationData);
        if (ack) {
            System.out.println("消息成功发送1");
        } else {
            System.out.println("消息发送失败:" + s+"\n重新发送");

        }
    }
}
