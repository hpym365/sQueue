package com.senyint.squeue.result;

import java.io.Serializable;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-6 下午12:53
 */
public class Result implements Serializable {

    private String resCode;
    private String resMsg;

    private Object data;

    public Result() {
    }

    public static Result succResult() {
        Result result = new Result();
        result.resCode = ResultCode.RESULT_CODE_SUCC;
        return result;
    }

    public static Result failResult() {
        Result result = new Result();
        result.resCode = ResultCode.RESULT_CODE_FAIL;
        return result;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resCode='" + resCode + '\'' +
                ", resMsg='" + resMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
