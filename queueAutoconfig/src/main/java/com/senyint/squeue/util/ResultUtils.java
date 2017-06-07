package com.senyint.squeue.util;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.senyint.squeue.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-6 下午1:53
 */
public class ResultUtils {

    private static Logger logger = LoggerFactory.getLogger(ResultUtils.class);

    /**
     * @param json the json
     * @return the result
     * @throws IOException the io exception
     * @Version 1.0
     * @Date 20170606 14:04:28
     * @Author hpym365 @gmail.com
     * @Description Get  Result by json.
     */
    public static Result getResult(String json) throws IOException {

//        Result jsonMap = (Map) com.alibaba.fastjson.JSONObject.parse(json,Result.class);
        Result result = JSON.parseObject(json, Result.class);
//        System.out.println("jsonMap:"+jsonMap);
        return result;

    }


    public static Object queryCollectionChangeKeyUnderToCamel(Object object) {
        if (object instanceof Map) {
            return mapKeyUnderToCamel((Map) object);
        }
        if (object instanceof List) {
            List list = (List) object;
            List resList = new ArrayList();
            for (Object o : list) {
                if (o instanceof Map) {
                    resList.add(mapKeyUnderToCamel((Map) o));
                } else {
                    resList.add(o);
                }
                return resList;
            }
        }
        return object;
    }

    private static Map mapKeyUnderToCamel(Map map) {

        Map resultMap = new HashMap();
        for (Object key : map.keySet()) {
            Object val = map.get(key);
            if (key instanceof String) {
                String resKey = StringUtils.camelCaseName((String) key);
                resultMap.put(resKey, val);
            } else {
                resultMap.put(key, val);
            }

        }
        return resultMap;
    }
}
