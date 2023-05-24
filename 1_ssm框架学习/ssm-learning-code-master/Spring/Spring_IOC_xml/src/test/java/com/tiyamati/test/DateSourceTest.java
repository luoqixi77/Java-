package com.tiyamati.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DateSourceTest {
    @Test
    public void date(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-config.xml");
        DruidDataSource datesource = ioc.getBean(DruidDataSource.class);
        System.out.println(datesource.getConnectCount());
    }
}
