package com.senyint.squeue.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-7 上午12:45
 */
public class RestUtils {
    /**
     * @param param the param
     * @param keys  the keys
     * @throws IllegalArgumentException the illegal argument exception
     * @Version 1.0
     * @Date 20170607 00:45:33
     * @Author hpym365 @gmail.com
     * @Description Check  param not null.
     */
    public static void checkParamNotNull(Map param, String... keys) throws IllegalArgumentException {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        String keyCol = "";
        for (String key : keys) {
            keyCol = keyCol + ":" + key;
        }

        if (param == null || param.size()==0) {
            throw new IllegalArgumentException("调用该接口至少传入一个参数" + keyCol);
        }
        param.put("checkParamNotNull", false);

        param.forEach((key, value) -> {
            if ((boolean) param.get("checkParamNotNull") == true) {
                return;
            }
            for (String s : keys) {
                if (s.equals(key)) {
                    param.put("checkParamNotNull", true);
                    return;
                }
            }
        });

        if ((boolean) param.get("checkParamNotNull") == false) {
            throw new IllegalArgumentException("调用方法至少传入一个参数" + keyCol);
        }
    }

    /**
     * @param args the args
     * @Version 1.0
     * @Date 20170607 00:45:33
     * @Author hpym365 @gmail.com
     * @Description Main.
     */
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("a1", "1");

        checkParamNotNull(map, "a", "b", "c");
    }
}
