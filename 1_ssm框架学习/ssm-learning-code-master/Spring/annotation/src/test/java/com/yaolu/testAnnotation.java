package com.yaolu;

import com.yaolu.controller.UserController;
import com.yaolu.dao.UserDao;
import com.yaolu.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAnnotation {
    @Test
    public void test(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-annocation.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.save();
    }
}
