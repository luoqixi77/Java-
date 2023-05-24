package com.Lambda;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

public class LambdaTest {
    public static void main(String[] args) {
        //如果一个匿名内部类中是一个接口，而且里面只有一个抽象方法，那么就可以使用Lambda表达式简化
//        new Thread(new Runnable(){
//            @Override
//            public void run() {
//                System.out.println("线程正在运行。。。。。。。");
//            }
//        }).start();
//
//        new Thread(()->{
//            System.out.println("线程正在运行......");
//        }).start();
//

//        练习1：
//        int i=calculateNum(new IntBinaryOperator() {
//            @Override
//            public int applyAsInt(int left, int right) {
//                return left+right;
//            }
//        });
//        System.out.println(i);
//
//        System.out.println(calculateNum(((int left, int right) -> {
//            return left + right;
//        })));
//    }
//
//
//    public static int calculateNum(IntBinaryOperator intBinaryOperator){
//        int a=10;
//        int b=20;
//        return intBinaryOperator.applyAsInt(a,b);
//    }


//        //        练习2：
//        printNum(new IntPredicate() {
//            @Override
//            public boolean test(int value) {
//                return value > 5;
//            }
//        });
//
//        printNum((int value)->{
//            return value>5;
//        });
//    }
//
//    public static void printNum(IntPredicate predicate){
//        int[] arr={1,2,3,4,5,6,7,8,9,10};
//        for (int i: arr) {
//            if (predicate.test(i)){
//                System.out.println(i);
//            }
//        }

//        练习3：
        System.out.println(typeConver(new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                return Integer.valueOf(s);
            }
        }));


        typeConver(s ->Integer.valueOf(s));

    }

    public static <R> R typeConver(Function<String,R> function){
        String str="12345";
        R result = function.apply(str);
        return result;
    }
}
