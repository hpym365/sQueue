package com.senyint.squeue.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.senyint.squeue.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, new TypeReference<Result>() {
        });

    }


    public static void keyUnderToCamel(Object object) {

        if (object instanceof Map) {
            mapKeyUnderToCamel((Map) object);
        }

        if (object instanceof List) {
            List list = (List) object;
            for (Object o : list) {
                mapKeyUnderToCamel((Map) o);
            }
        }

    }

    private static void mapKeyUnderToCamel(Map map) {
        Map resultMap = new HashMap();
        for (Object key : map.keySet()) {
            Object val = map.get(key);
            if (key instanceof String) {
                String resKey = StringUtils.camelCaseName((String) key);
                resultMap.put(resKey, val);
            }else{
                resultMap.put(key,val);
            }

        }
        map=resultMap;
    }
}
