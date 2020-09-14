package com.cest.listener.listener2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EventProcess {

    @Autowired
    private ApplicationContext applicationContext;

    public void process(){
        for(int i = 1; i <= 10; i++){
            try {
                /**** 为了演示效果睡眠一秒 ****/
                Thread.sleep(1000L);
                applicationContext.publishEvent(new CustomEvent(this,i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
