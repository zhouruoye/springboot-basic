package com.cest.design.structural.proxy.demo2.cglibproxy;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * cglib代理
 * JDK实现动态代理需要实现类通过接口定义业务方法，对于没有接口的类，如何实现动态代理呢，
 * 这就需要CGLib了。CGLib采用了非常底层的字节码技术，其原理是通过字节码技术为一个类创
 * 建子类，并在子类中采用方法拦截的技术拦截所有父类方法的调用，顺势织入横切逻辑。但因
 * 为采用的是继承，所以不能对final修饰的类进行代理。JDK动态代理与CGLib动态代理均是实
 * 现Spring AOP的基础。
 * Created by cestlavie on 2019/11/14.
 */
@Slf4j
@Component
@Scope("prototype")
public class CglibProxy implements MethodInterceptor {

    private Object object;

    //初始化
    public Object getInstance(final Object target) {
        this.object = target;

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("cglib代理执行之前");
        Object invoke = methodProxy.invoke(object, objects);
        log.info("cglib代理执行之后");
        return invoke;
    }
}
