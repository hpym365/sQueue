package com.senyint.test;

import com.senyint.squeue.DataHandleApplication;
import com.senyint.squeue.queue.service.QueueService;
import com.senyint.squeue.result.Result;
import com.senyint.squeue.util.ResultUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-5 下午1:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataHandleApplication.class)
public class TestServ {
//    @Autowired
//    TestService serv;
//
//    @Test
//    public void right() {
//        serv.right();
//    }
//
//    @Test
//    public void wrong() {
//        serv.wrong();
//    }

    @Autowired
    QueueService queueService;

    @Test
    public void insertQueue() {
        Map map = new HashMap();
        map.put("queueNum", "dfdfa");
        map.put("queueName", "dfdf");
        map.put("queueDesc", "dfdf");
        map.put("deptId", "1");

        queueService.insertQueue(map);
    }


    @Autowired
    private RestTemplate rest;


    @Test
    public void findQueueByToken() throws IOException {
        String token = "abcd";
        Map param = new HashMap();
        param.put("token",token);
        param.put("queueNum",1);

        String res = rest.postForObject("http://localhost:9090/data/findQueue", param, String.class);
        System.out.println("String res:"+res);

//        Map<String, Object> map = new HashMap<String, Object>();
        Result result = ResultUtils.getResult(res);
        System.out.println("ResultUtils.getResult(res):"+result.toString());
//        rest.getForObject("http://localhost:8888/receive/" + token,Map.class);
    }

}
