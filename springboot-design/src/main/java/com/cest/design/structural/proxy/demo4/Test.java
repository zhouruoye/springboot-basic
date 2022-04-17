package com.cest.design.structural.proxy.demo4;

public class Test {

    public static void main(String[] args) {
        Person instance = (Person)new JDKProxy().getInstance(new EasyGirl());
        instance.findLove();
    }
}
