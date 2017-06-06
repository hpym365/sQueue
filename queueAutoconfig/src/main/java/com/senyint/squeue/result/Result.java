package com.senyint.squeue.result;

import com.senyint.squeue.util.ResultUtils;

import java.io.Serializable;
import java.util.List;

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
        result.resMsg = ResultCode.RESULT_MSG_SUCC;
        return result;
    }

    public static Result failResult() {
        Result result = new Result();
        result.resCode = ResultCode.RESULT_CODE_FAIL;
        result.resMsg = ResultCode.RESULT_MSG_FAIL;
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
        if(data==null || (data instanceof List && ((List) data).size()==0)){
            this.resCode=ResultCode.RESULT_CODE_NODATA;
            this.resMsg=ResultCode.RESULT_MSG_NODATA;
        }
        ResultUtils.keyUnderToCamel(data);
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
