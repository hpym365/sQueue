package com.senyint.squeue.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.senyint.squeue.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-6 下午1:53
 */
public class ResultUtil {

    private static Logger logger = LoggerFactory.getLogger(ResultUtil.class);

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
        return mapper.readValue(json, new TypeReference<Result>() {});

    }
}
