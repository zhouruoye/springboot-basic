package com.cest.listener.listener2;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomApplicationListener implements ApplicationListener<CustomEvent>
{
    private String msg;

    @Override
    public void onApplicationEvent(CustomEvent event) {
        msg = "第"+event.getIndex()+"轮";
        System.out.println(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
