package com.cest.basictest;

public class StaticTest {
    public static void main(String[] args) {
        //静态成员变量    测试
        System.out.println(StaticTestObject.welcome);
        System.out.println("----------------------");

        //静态方法    测试
        StaticTestObject.test();
        System.out.println("----------------------");

        new StaticTestObject().test1();
        System.out.println("----------------------");

        new StaticTestObject().test1();
        System.out.println("----------------------");
        /*
         * 执行上面方法会获得很多信息：
         * 1.有static修饰的代码块，在类被使用的时候,首先执行，并且只执行一次
         * 2.没有static修饰的代码块，在类实例化的时候会被调用，并且每次实例化都会被调用一次
         * 3.代码块的执行总是先于构造方法
         */
    }
}