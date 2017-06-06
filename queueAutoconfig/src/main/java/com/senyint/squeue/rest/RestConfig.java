package com.senyint.squeue.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-6 上午11:11
 */
@Configuration
public class RestConfig {

    @Autowired
    private RestTemplateBuilder builder;

    /**
     * @return the rest template
     * @Version 1.0
     * @Date 20170606 15:12:40
     * @Author hpym365 @gmail.com
     * @Description Rest  template rest template.
     * 使用RestTemplateBuilder来实例化RestTemplate对象 spring默认已经注入了RestTemplateBuilder实例
     */
    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }
}
