package com.senyint.queue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-5-18 下午9:32
 */
@SpringBootApplication
@RestController
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }


    @RequestMapping("/")
    public String test(){
        return "123";
    }

}
