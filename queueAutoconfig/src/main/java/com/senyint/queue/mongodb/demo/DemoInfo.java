//package com.senyint.queue.mongodb.demo;
//
//import org.springframework.data.annotation.Id;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author hpym365@gmail.com
// * @Description
// * @Date 17-5-19 下午3:38
// */
//public class DemoInfo {
//
//
//    //id属性是给mongodb用的，用@Id注解修饰
//
//    @Id
//    private String id;
//
//
//    private String name;
//
//
//    private int age;
//
//    private Map map;
//
//    public Map getMap() {
//        return map;
//    }
//
//    public void setMap(Map map) {
//        this.map = map;
//    }
//
//    public String getName() {
//
//        return name;
//
//    }
//
//
//    public void setName(String name) {
//
//        this.name = name;
//
//    }
//
//
//    public int getAge() {
//
//        return age;
//
//    }
//
//
//    public void setAge(int age) {
//
//        this.age = age;
//
//    }
//
//
//    @Override
//
//    public String toString() {
//
//        return "DemoInfo [id=" + id + ", name=" + name + ", age=" + age + "]";
//
//    }
//
//}