package com.lilisi.spring.annotation;

import com.alibaba.druid.sql.ast.statement.SQLJoinTableSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggerAspect {

//    @Before("execution(public int com.lilisi.spring.annotation.CalculatorImpl.add(int,int))")
//    public void beforeMethod(){
//        System.out.println("测试成功");
//    }


    @Pointcut("execution(* com.lilisi.spring.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void beforeMethod(JoinPoint joinPoint){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("第二次测试，签名信息："+signature+"方法："+signature.getName()+",参数："+ Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("方法执行完毕："+signature.getName());
    }

    //Object result:设置接收目标对象方法的返回值的
    //returning="result":设置接收目标对象方法的返回值的一个参数的参数名
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturnMethod(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("方法返回值通知："+signature.getName()+"结果："+result);
    }

    /**
     * 在异常通知，若要获取目标对象的异常，
     * 只需要通过@AfterThrowing注解的throwing属性
     * 就可以将通知方法的某个参数指定为接收目标对象方法的返回值的参数
     * @param joinPoint
     * @param e
     */

    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void afterThrowingMethod(JoinPoint joinPoint,Exception e){
        Signature signature = joinPoint.getSignature();
        System.out.println("方法："+signature.getName()+"异常通知："+e);
    }

    @Around("pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result=null;
        try {
            System.out.println("环绕通知--》前置通知");
            //表示目标对象方法的执行
            result=joinPoint.proceed();
            System.out.println("环绕通知--》返回通知");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知--》异常通知");
        }finally {
            System.out.println("环绕通知--》后置通知");
        }
        return result;
    }
}
