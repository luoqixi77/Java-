package com.tiyamati.test;

import com.tiyamati.controller.UserController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Autowire {
    @Test
    public void test(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserController bean = ioc.getBean(UserController.class);
        bean.testSave();
    }
}
