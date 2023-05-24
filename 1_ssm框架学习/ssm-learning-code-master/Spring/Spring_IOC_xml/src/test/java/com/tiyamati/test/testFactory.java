package com.tiyamati.test;

import com.tiyamati.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testFactory {
    @Test
    public void factoryTest(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
    }
}
