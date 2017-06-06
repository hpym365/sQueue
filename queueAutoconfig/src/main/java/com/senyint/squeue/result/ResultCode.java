package com.senyint.squeue.result;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-6 下午12:56
 */
public interface ResultCode {

    public static String RESULT_CODE_SUCC ="00";//成功
    public static String RESULT_MSG_SUCC ="成功";//成功


    public static String RESULT_CODE_FAIL ="01";//系统失败
    public static String RESULT_MSG_FAIL ="系统异常失败";//系统失败

    public static String RESULT_CODE_NODATA ="02";//无返回数据
    public static String RESULT_MSG_NODATA ="未查询到数据";//无返回数据


}
