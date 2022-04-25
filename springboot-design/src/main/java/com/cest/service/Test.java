package com.cest.service;

public class Test {

    private static int a = 1;

    static {
        a = 0;
        System.out.println("111");
    }

    public static void main(String[] args) {
        System.out.println(a);
    }
}
