package com.tiyamati.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        //bean的生命周期初始化之前执行
        System.out.println("postProcessBeforeInitialization后置处理器");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //bean的生命周期初始化之后执行
        System.out.println("postProcessAfterInitialization后置处理器");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
