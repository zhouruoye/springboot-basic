package com.cest.listener.listener1;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

    private Pig pig;
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyEvent(Object source,Pig pig) {
        super(source);
        this.pig = pig;
    }

    public Pig getPig() {
        return pig;
    }

    public void setPig(Pig pig) {
        this.pig = pig;
    }
}
