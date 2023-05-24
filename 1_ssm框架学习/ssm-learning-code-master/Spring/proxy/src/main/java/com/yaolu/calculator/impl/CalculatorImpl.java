package com.yaolu.calculator.impl;

import com.yaolu.calculator.Calculator;

public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result=i+j;
        System.out.println("结果为："+result);
        return result;
    }

    @Override
    public int sub(int i, int j) {

        int result=i-j;
        System.out.println("结果为："+result);

        return result;
    }

    @Override
    public int mul(int i, int j) {

        int result=i*j;
        System.out.println("结果为："+result);

        return result;
    }

    @Override
    public int div(int i, int j) {

        int result=i/j;
        System.out.println("结果为："+result);

        return result;
    }
}
