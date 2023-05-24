package com.itheima.reggie.common;

public class BaseContext {
    private static ThreadLocal<Long> threadLocal=new ThreadLocal<>();

    //保存用户id
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }
    //获取用户当前id
    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
