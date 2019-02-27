package com.cd.common.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Configuration
public class Aop {
    private static final Logger LOGGER = LoggerFactory.getLogger(Aop.class);


    /*
    定义切点
     */
    @Pointcut(value = "execution(* com.cd.*.api.*.*(..))")
    public void point() {
    }

    /*
    定义前置通知
     */
    @Before("point()")
    public void adviceBefore() {
        LOGGER.info("前置通知触发");
        //获取所有的请求url和请求的ip地址
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String uri = request.getRequestURI();
        String method = request.getMethod();
        String ip = request.getRemoteHost();
        LOGGER.info("请求的url:{},method:{},ip:{}", uri, method, ip);

    }
}
