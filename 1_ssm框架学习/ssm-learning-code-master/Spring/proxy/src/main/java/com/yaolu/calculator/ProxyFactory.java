package com.yaolu.calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * ClassLoader loader,类的构造器
     * Class<?>[] interfaces,目标对象实现的所有接口所组成的数组
     * InvocationHandler h，设置代理对象实现目标对象的代理过程，即代理类中如何重写接口中的抽象方法
     * @return
     */
    public Object getProxy(){
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler h=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               //proxy:表示代理对象
//                method:表示要执行的方法
//                args：表示要执行的方法的参数列表
                Object result = null;
                try {
                    System.out.println("日志，方法："+method.getName()+"参数："+Arrays.toString(args));
                    result = method.invoke(target, args);
                    System.out.println("日志，方法："+method.getName()+"结果："+result);
                } catch (Exception e) {
                    System.out.println("Error,"+e);
                    e.printStackTrace();
                } finally {
                    System.out.println("end");
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,h);
    }
}
