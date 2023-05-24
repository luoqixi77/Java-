package com.lilisi.spring;

import com.lilisi.spring.annotation.Calculator;
import com.lilisi.spring.annotation.CalculatorImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test_0(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator bean = ioc.getBean(Calculator.class);
        bean.div(1,1);
    }

    @Test
    public void test_2(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("aop-xml.xml");
        com.lilisi.spring.xml.Calculator ca = ioc.getBean(com.lilisi.spring.xml.Calculator.class);
        ca.add(1,2);
    }
}
