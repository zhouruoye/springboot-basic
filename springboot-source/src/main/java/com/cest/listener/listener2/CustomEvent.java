package com.cest.listener.listener2;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

    private int index;
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public CustomEvent(Object source,int index) {
        super(source);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
