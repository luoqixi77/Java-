package com.yaolu.proxy;

import com.yaolu.calculator.Calculator;
import com.yaolu.calculator.CalculatorStaticProxy;
import com.yaolu.calculator.ProxyFactory;
import com.yaolu.calculator.impl.CalculatorImpl;
import org.junit.Test;

public class ProxyTest {
    @Test
    public void test(){
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        proxy.add(1,2);
    }

    @Test
    public void testProxy(){
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1,0);
    }
}
