package com.cest.design.structural.proxy.demo3.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GHDynamicproxy implements InvocationHandler {

    private Object codeTest;

    public Object getInstance(Object codeTest){
        this.codeTest = codeTest;
        Class<?> codeTestClass = codeTest.getClass();
        return Proxy.newProxyInstance(codeTestClass.getClassLoader(),codeTestClass.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(this.codeTest, null);
        after();
        return invoke;
    }

    public void before(){
        System.out.println("让GH代理测试");
    }

    public void after(){
        System.out.println("让GH直接提JIRA");
    }
}
