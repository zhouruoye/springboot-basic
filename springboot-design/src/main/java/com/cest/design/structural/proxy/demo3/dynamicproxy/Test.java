package com.cest.design.structural.proxy.demo3.dynamicproxy;

public class Test {

    public static void main(String[] args) {
        CodeTest instance = (CodeTest)new GHDynamicproxy().getInstance(new ZXCodeTest());
        instance.codeTest();
    }
}
