package com.cest.basictest;

public class StaticTestObject {

    static {
        System.out.println("初始化代码块~");
    }

    {
        System.out.println("一个代码块");
    }

    //静态成员变量    属于类
    public static String welcome = "www.cxyapi.com";

    public StaticTestObject() {
        System.out.println("构造函数");
    }

    public static void test() {
        System.out.println("静态的test方法");
    }

    public void test1() {
        System.out.println("test1方法");
    }
}
