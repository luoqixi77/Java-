package com.tiyamati.test;

import com.tiyamati.pojo.student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {
    @Test
    public void testScope(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-scope.xml");
        student bean1 = ioc.getBean(student.class);
        student bean2 = ioc.getBean(student.class);
        System.out.println(bean1 == bean2);
    }
}
