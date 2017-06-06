//package com.senyint.queue.mongodb.utils;
//
//import com.mongodb.BasicDBObject;
//import com.mongodb.DBCursor;
//import com.mongodb.DBObject;
//import com.mongodb.WriteResult;
//import com.mongodb.util.JSON;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author hpym365@gmail.com
// * @Description MongoDB 工具类 增删查改
// * @Date 17-5-19 下午10:59
// */
//
////@Component
//public class MongoDbTools {
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    /**
//     * @param table the table name
//     * @return the list
//     * @Version 1.0
//     * @Date 20170519 23:02:51
//     * @Author hpym365 @gmail.com
//     * @Description Find  all list.
//     */
//    public List selectAll(String table) {
//        DBCursor dbObjects = mongoTemplate.getCollection(table).find();
//        return dbObjects.toArray();
//    }
//
//    /**
//     * @param table the table
//     * @param start the start
//     * @param end   the end
//     * @return the list
//     * @Version 1.0
//     * @Date 20170520 00:52:39
//     * @Author hpym365 @gmail.com
//     * @Description Select  all list.
//     */
//    public List selectAll(String table, int start, int end) {
//        DBCursor dbObjects = mongoTemplate.getCollection(table).find().skip(start).limit(end);
//        return dbObjects.toArray();
//    }
//
//    /**
//     * @param table the table name
//     * @param map   the query where map
//     * @return the list
//     * @Version 1.0
//     * @Date 20170519 23:02:51
//     * @Author hpym365 @gmail.com
//     * @Description Find  by map list.
//     */
//    public List selectByMap(String table, Map map) {
//        BasicDBObject query = new BasicDBObject(map);
//        DBCursor dbObjects = mongoTemplate.getCollection(table).find(query);
//        return dbObjects.toArray();
//    }
//
//    /**
//     * @param table the table
//     * @param map   the map
//     * @param start the start
//     * @param end   the end
//     * @return the list
//     * @Version 1.0
//     * @Date 20170520 00:52:39
//     * @Author hpym365 @gmail.com
//     * @Description Select  by map list.
//     */
//    public List selectByMap(String table, Map map, int start, int end) {
//        BasicDBObject query = new BasicDBObject(map);
//        DBCursor dbObjects = mongoTemplate.getCollection(table).find(query).skip(start).limit(end);
//        return dbObjects.toArray();
//    }
//
//    /**
//     * @param table the table
//     * @param json  the json
//     * @return the list
//     * @Version 1.0
//     * @Date 20170520 00:52:39
//     * @Author hpym365 @gmail.com
//     * @Description Select  by json list.
//     */
//    public List selectByJson(String table, String json) {
//        DBObject query = (DBObject) JSON.parse(json);
//        DBCursor dbObjects = mongoTemplate.getCollection(table).find(query);
//        return dbObjects.toArray();
//    }
//
//    /**
//     * @param table the table
//     * @param json  the json
//     * @param start the start
//     * @param end   the end
//     * @return the list
//     * @Version 1.0
//     * @Date 20170520 00:52:39
//     * @Author hpym365 @gmail.com
//     * @Description Select  by json list.
//     */
//    public List selectByJson(String table, String json, int start, int end) {
//        DBObject query = (DBObject) JSON.parse(json);
//        DBCursor dbObjects = mongoTemplate.getCollection(table).find(query).skip(start).limit(end);
//        return dbObjects.toArray();
//    }
//
//    /**
//     * @param table the table
//     * @param json  the json
//     * @return the write result
//     * @Version 1.0
//     * @Date 20170520 00:52:39
//     * @Author hpym365 @gmail.com
//     * @Description Insert  write result.
//     */
//    public WriteResult insert(String table, String json) {
//        DBObject data = (DBObject) JSON.parse(json);
//        return mongoTemplate.getCollection(table).insert(data);
//    }
//
//    /**
//     * @param table the table
//     * @param map   the map
//     * @return the write result
//     * @Version 1.0
//     * @Date 20170520 00:52:39
//     * @Author hpym365 @gmail.com
//     * @Description Insert  write result.
//     */
//    public WriteResult insert(String table, Map map) {
//        DBObject data = new BasicDBObject(map);
//        return mongoTemplate.getCollection(table).insert(data);
//    }
//
//    /**
//     * @param table  the table
//     * @param query  the query
//     * @param update the update
//     * @return the write result
//     * @Version 1.0
//     * @Date 20170520 00:52:39
//     * @Author hpym365 @gmail.com
//     * @Description Update  write result.
//     */
//    public WriteResult update(String table, Map query, Map update) {
//        Map updateWarp = new HashMap();
//        updateWarp.put("$set",update);
//        DBObject q = new BasicDBObject(query);
//        DBObject u = new BasicDBObject(updateWarp);
//        return mongoTemplate.getCollection(table).update(q,u,true,true);
//    }
//
//    /**
//     * @param table  the table
//     * @param query  the query
//     * @param update the update
//     * @return the write result
//     * @Version 1.0
//     * @Date 20170520 00:52:39
//     * @Author hpym365 @gmail.com
//     * @Description Replace  one write result.
//     */
//    public WriteResult replaceOne(String table, Map query, Map update) {
//        DBObject q = new BasicDBObject(query);
//        DBObject u = new BasicDBObject(update);
//        return mongoTemplate.getCollection(table).update(q,u);
//    }
//}
