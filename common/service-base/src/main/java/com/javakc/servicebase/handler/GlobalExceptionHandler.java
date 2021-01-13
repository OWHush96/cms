package com.javakc.servicebase.handler;

import com.javakc.commonutils.api.APICODE;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description:全局统一异常处理类
 * @Date:2021/1/13 001311:31
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public APICODE errorHandler(Exception e){
        e.printStackTrace();
        return APICODE.ERROR().message("服务器异常");

    }
    @ExceptionHandler(HctException.class)
    @ResponseBody
    public APICODE errorHandler(HctException e){
        e.printStackTrace();
        return APICODE.ERROR().code(e.getCode()).message(e.getMessage());
    }
}

