package com.cest.threadpool.mythreadpool;

public class RunnableDenyException extends RuntimeException{

    public RunnableDenyException(String msg) {
        super(msg);
    }
}
