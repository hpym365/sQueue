//package com.senyint.queue.mongodb.demo;
//
//import com.mongodb.WriteResult;
//import com.senyint.queue.mongodb.utils.MongoDbTools;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author hpym365@gmail.com
// * @Description
// * @Date 17-5-19 下午3:40
// */
//@RestController
//public class DemoController {
//
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Autowired
//    MongoDbTools db;
//
//    @RequestMapping("selectall")
//    public List selectall() {
//        return db.selectAll("test");
//    }
//
//    @RequestMapping("selectjson")
//    public List selectjson(@RequestParam String sex) {
//        String json = "{sex:'" + sex + "'}";
//        return db.selectByJson("test", json);
//    }
//
//    @RequestMapping("selectmap")
//    public List selectmap(@RequestParam String sex) {
//        Map map = new HashMap();
//        map.put("sex",sex);
//        return db.selectByMap("test", map);
//    }
//
//
//    @RequestMapping("insertmap")
//    public String insertMap() {
//        Map map = new HashMap();
//        map.put("name","lisimap");
//        map.put("age","25");
//        map.put("sex","nv");
//        WriteResult result = db.insert("test", map);
//        return result.toString();
//    }
//
//    @RequestMapping("insertjson")
//    public String insertJson() {
//        String json = "{name:'zhangsan',age:22,sex:'nan'}";
//        WriteResult result = db.insert("test", json);
//        return result.toString();
//
//    }
//
//    @RequestMapping("updatemap")
//    public String updateMap(){
//        Map query = new HashMap();
//        query.put("name","lisi");
//
//        Map s = new HashMap();
//        s.put("gggg","dfdf");
//
//        return db.update("test",query,s).toString();
//    }
//
//    @RequestMapping("replaceOne")
//    public String replaceMap(){
//        Map query = new HashMap();
//        query.put("sex","nvaa");
//
//        Map s = new HashMap();
//        s.put("bbbb","aaaaa");
//
//        return db.replaceOne("test",query,s).toString();
//    }
//
//    @RequestMapping("add")
//    public String add() {
//        Test map = new Test();
//        map.put("name", "张三");
//        map.put("age", "22");
//        map.put("sex", "男女");
//
//        // test.save(map);
//        return "okok";
//    }
//
//
////    @RequestMapping("find")
////
////    public List<DemoInfo> find() {
////        return demoInfoRepository.findAll();
////    }
////
////
////    @RequestMapping("findByName")
////
////    public DemoInfo findByName() {
////
////        return demoInfoRepository.findByName("张三");
////
////    }
//
//
//}