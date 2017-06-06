package com.senyint.squeue.exception;

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
    //添加全局异常处理流程，根据需要设置需要处理的异常，本文以MethodArgumentNotValidException为例
    @ExceptionHandler(value = Throwable.class)
    public Object MethodArgumentNotValidHandler(HttpServletRequest request,
                                                Throwable exception) throws Exception {
        exception.printStackTrace();
        System.out.println("GlobalExceptionHandler");
        return "123";
//        //按需重新封装需要返回的错误信息
//        List<ArgumentInvalidResult> invalidArguments = new ArrayList<>();
//        //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
//        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
//            ArgumentInvalidResult invalidArgument = new ArgumentInvalidResult();
//            invalidArgument.setDefaultMessage(error.getDefaultMessage());
//            invalidArgument.setField(error.getField());
//            invalidArgument.setRejectedValue(error.getRejectedValue());
//            invalidArguments.add(invalidArgument);
//        }
//
//        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.PARAMETER_ERROR.getErrcode(), ResultStatusCode.PARAMETER_ERROR.getErrmsg(), invalidArguments);
//        return resultMsg;
    }
}