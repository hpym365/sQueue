package com.senyint.queue.mongodb.demo;

import org.springframework.data.annotation.Id;

import java.util.HashMap;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-5-19 下午4:48
 */
public class Test extends HashMap{

    @Id
    public String id;


}
