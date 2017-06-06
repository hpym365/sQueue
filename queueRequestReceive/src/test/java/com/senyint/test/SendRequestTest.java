package com.senyint.test;

import com.senyint.squeue.RequestReceiveApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-5-31 下午4:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=RequestReceiveApplication.class)
public class SendRequestTest {

    @Autowired
    private RestTemplate rest;

    @Test
    public void test() {
//        RestTemplate restTemplate = new RestTemplate();

        String token="123";
        Map map = new HashMap();
        map.put("queueNum","fs-cs-fubu-A");
        map.put("patientName","王小二");
        map.put("queueDate",LocalDate.now());
        map.put("optionType",1);//1-增  2-删 3-改 4-查


        String res = rest.postForObject("http://localhost:8888/receive/" + token, map, String.class);
        System.out.println(res);
//        rest.getForObject("http://localhost:8888/receive/" + token,Map.class);
    }
}
