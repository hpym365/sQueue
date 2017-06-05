package com.senyint.queue.ctrl;

import com.senyint.queue.rabbitmq.utils.RabbitMQDAO;
import org.apache.http.HttpRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Title Http recive controller
 * @Version 1.0
 * @Date 20170531 16:08:53
 * @Author hpym365 @gmail.com
 * @Description 请求接收
 */
@RestController
public class HttpReciveController implements RabbitTemplate.ConfirmCallback {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitMQDAO dao;

    public AtomicInteger count = new AtomicInteger(1);

    /**
     * @param request the request
     * @param token   the token
     * @return the string
     * @Version 1.0
     * @Date 20170531 16:08:40
     * @Author hpym365 @gmail.com
     * @Description Test  string.
     */
    //upstream_hash  url_hash  /receive/token
    @RequestMapping(value = {"/receive/{token}", "/receive"}, method = RequestMethod.POST)
    public String receive(HttpServletRequest request, @RequestBody Map map, @PathVariable(required = false) String token) {
        logger.info("打印接收到的token：{}"+token);
        logger.info("接受到的Map", map.toString());
        logger.warn("## Warn  Information ##: {}", token);
        logger.error("## Error Information ##: {}", token);

        if (token == null) {
            throw new IllegalArgumentException("无效的queue号");
        }
        for (int i = 0; i < 10; i++) {
            CorrelationData correlationId = new CorrelationData("" + count.getAndIncrement());

            String json = "{\"name\":zhangsan,\"age\":" + i + "}";

            dao.sendMessage("receive_exchange", "receive_key", json, correlationId);
//            rabbitTemplate.setConfirmCallback(this);//设置回调
//            //消息发送到exchange
//            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE,RabbitMQConfig.ROUTING_KEY,json,correlationId);
        }
        System.out.println("此次coutnt1:" + count.get());

        Map res = new HashMap();
        res.put("code","00");
        res.put("msg","succ");

        return res.toString();
    }


//    @RequestMapping(value = {"/receive/{token}", "/receive"}, method = RequestMethod.GET)
    public String test(HttpServletRequest request, @PathVariable(required = false) String token) {
//        System.out.println(token);
//        if (token == null) {
//            throw new IllegalArgumentException("无效的queue号");
//        }
//        for (int i = 0; i < 10; i++) {
//            CorrelationData correlationId = new CorrelationData("" + count.getAndIncrement());
//
//            String json = "{\"name\":zhangsan,\"age\":" + i + "}";
//
//            dao.sendMessage("receive_exchange", "receive_key", json, correlationId);
////            rabbitTemplate.setConfirmCallback(this);//设置回调
////            //消息发送到exchange
////            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE,RabbitMQConfig.ROUTING_KEY,json,correlationId);
//        }
//        System.out.println("此次coutnt1:" + count.get());
        return "test";
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String s) {
        System.out.println(" 回调id:" + correlationData);
        if (ack) {
            System.out.println("消息成功发送1");
        } else {
            System.out.println("消息发送失败:" + s + "\n重新发送");

        }
    }
}
