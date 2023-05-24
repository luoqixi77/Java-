package com.yaolu.calculator;

import com.yaolu.calculator.impl.CalculatorImpl;

public class CalculatorStaticProxy implements Calculator {

    private CalculatorImpl calculatorImpl;

    public CalculatorStaticProxy(CalculatorImpl calculatorImpl) {
        this.calculatorImpl = calculatorImpl;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("日志，方法：add，参数："+"i"+"j");
        int result=calculatorImpl.add(i,j);
        System.out.println("日志，方法：add，结果："+result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("日志，方法：sub，参数："+"i"+"j");
        int result=calculatorImpl.sub(i,j);
        System.out.println("日志，方法：sub，结果："+result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("日志，方法：mul，参数："+"i"+"j");
        int result=calculatorImpl.mul(i,j);
        System.out.println("日志，方法：mul，结果："+result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("日志，方法：div，参数："+"i"+"j");
        int result=calculatorImpl.div(i,j);
        System.out.println("日志，方法：div，结果："+result);
        return result;
    }
}
