package com.tiyamati.test;

import com.tiyamati.pojo.stuClass;
import com.tiyamati.pojo.student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {
    @Test
    public void testStudent(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        student student = (student) ioc.getBean("student");
//        student student = ioc.getBean(student.class);
//        student student = ioc.getBean("student", student.class);
//        Person per = ioc.getBean(Person.class);
//        System.out.println(student);
//        System.out.println(per);
    }

    @Test
    public void testStd(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        student stu = ioc.getBean(student.class);
        System.out.println(stu);
    }

    @Test
    public void testSt(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        student student = ioc.getBean("studentTwo", student.class);
        System.out.println(student);
    }
    @Test
    public void testClass(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
       stuClass st = ioc.getBean("stuClass", stuClass.class);
        System.out.println(st);
    }

}
