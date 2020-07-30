package com.cest.listener.listener1;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ListenerBind {

    /**
     * 上下文对象
     */
    @Resource
    private ApplicationContext applicationContext;

    public void publish(Pig pig){
        // 通过上下文对象发布监听
        applicationContext.publishEvent(new MyEvent(this, pig));
    }
}
