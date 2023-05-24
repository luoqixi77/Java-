package com.tiyamate.testSpring;

import com.tiyamate.pojo.Helloworld;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TextSpring {
    @Test
    public void testSpring(){
        //获取IOC容器
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取IOC容器中的bean
        Helloworld helloworld = (Helloworld) ioc.getBean("helloworld");
        //调用
        helloworld.sayHello();
    }
}
