package com.cest.design.structural.proxy.demo4;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class JDKProxy implements InvocationHandler {

    private Object object;

    public Object getInstance(Object object) {
        this.object = object;
        Class<?> aClass = object.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(),
                aClass.getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(object, args);
        after();
        return invoke;
    }

    private void after() {
        System.out.println("OK的话，准备办事");
    }

    private void before() {
        System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }
}
