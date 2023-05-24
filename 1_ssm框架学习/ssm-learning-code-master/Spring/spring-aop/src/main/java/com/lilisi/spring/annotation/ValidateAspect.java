package com.lilisi.spring.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Order(1)//使用此注解可以设置切面的优先级，数字越小优先级越高
public class ValidateAspect {

    @Before("com.lilisi.spring.annotation.LoggerAspect.pointCut()")
    public void beforeMethod(){
        System.out.println("Validate--》前置通知");
    }
}
