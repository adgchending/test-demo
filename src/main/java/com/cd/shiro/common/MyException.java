package com.cd.shiro.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 认证异常
 * 处理shiro的AuthenticationException异常
 */
@ControllerAdvice
public class MyException {
    @ExceptionHandler(value = Exception.class)
    public String defuaultErrorHander(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();
        return "403";
    }
}
