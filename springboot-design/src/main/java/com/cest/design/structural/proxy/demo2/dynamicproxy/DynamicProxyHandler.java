package com.cest.design.structural.proxy.demo2.dynamicproxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by cestlavie on 2019/11/14.
 */
@Slf4j
@Component
@Scope("prototype")
public class DynamicProxyHandler implements InvocationHandler {

    private Object object;

    /**
     * 注意Proxy.newProxyInstance()方法接受三个参数：
     * ClassLoader loader:指定当前目标对象使用的类加载器,获取加载器的方法是固定的
     * Class<?>[] interfaces:指定目标对象实现的接口的类型,使用泛型方式确认类型
     * InvocationHandler:指定动态处理器，执行目标对象的方法时,会触发事件处理器的方法
     * @return
     */
    public Object bind(){
        Class cls = object.getClass();
        return Proxy.newProxyInstance(cls.getClassLoader(),
                cls.getInterfaces(),
                this);
    }

    public Object bind(Object object){
        this.object = object;
        Class cls = object.getClass();
        return Proxy.newProxyInstance(cls.getClassLoader(),
                cls.getInterfaces(),
                this);
    }

    public DynamicProxyHandler() {
    }

    public DynamicProxyHandler(Object o) {
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("代理方法之前调用");
        if("deleteEmpeById".equals(method.getName())){
            log.info("这是删除员工的方法,员工编号是:{}",args[0]);
        }
        Object invoke = method.invoke(object, args);
        log.info("代理方法之后调用");
        return invoke;
    }
}
