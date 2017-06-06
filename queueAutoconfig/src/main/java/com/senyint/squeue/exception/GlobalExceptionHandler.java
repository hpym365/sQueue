package com.senyint.squeue.exception;

import com.senyint.squeue.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-6 下午12:47
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(value = Throwable.class)
    public Result MethodArgumentNotValidHandler(HttpServletRequest request,
                                                Throwable exception) throws Exception {
        Result result = Result.failResult();
        result.setResMsg(exception.getMessage());
        exception.printStackTrace();
        System.out.println("GlobalExceptionHandler");
        return result;
    }
}