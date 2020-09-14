package com.cest.controller;

import com.cest.listener.listener2.CustomApplicationListener;
import com.cest.listener.listener2.EventProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 在实际工作的过程，我们经常需要监听一个任务实际完成的情况和进度。所以引入监听器的概念。
 * 设计一个任务：本任务简单设置：一个循环，每次循环都发布一下进度情况。
 */
@RestController
@RequestMapping("/count")
public class TestController2 {

    @Autowired
    private EventProcess eventProcess;

    @Autowired
    private CustomApplicationListener customApplicationListener;

    /**
     * localhost:8080/count/event
     * @return
     */
    @RequestMapping("/event")
    public String event(){
        eventProcess.process();
        return "success";
    }

    /**
     * localhost:8080/count/listener
     * @return
     */
    @RequestMapping("/listener")
    public String listener(){
        return customApplicationListener.getMsg();
    }
}
