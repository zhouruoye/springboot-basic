package com.cest.controller;


import com.cest.listener.listener1.ListenerBind;
import com.cest.listener.listener1.Pig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 代码说明：
 * 我想要监控内存中的两个对象，第一个为名为tom的猪，第二个为名为sec的猪。这两只猪在spring容器启动后，会交给spring管理，每当有用户请求controller层修改这两只猪的信息，
 * 都会通过监听器监听到，并将信息打印出来。
 */
@Controller
@RequestMapping("/pig")
public class PigController {

    @Autowired
    private ListenerBind listenerBind;

    /**
     * 通过spring 注入第一只猪，然后web每请求一次进行一次修改，测试监听器是否进行监听。
     */
    @Resource(name = "tom")
    private Pig tom;

    /**
     * 通过按照类型注入和@Qualifier注解拿到pig-sec
     */
    @Autowired
    @Qualifier("sec")
    private Pig sec;

    /**
     * localhost:8080/pig/hello
     * @return
     */
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    /**
     * 每次请求时候都去更改pig-tom的msg。
     *  localhost:8080/pig/configTom?msg="haha"
     *  localhost:8080/pig/configTom?msg="haha"&repub=true
     */
    @GetMapping(value = "/configTom")
    public void configTom(@RequestParam String msg, @RequestParam(value = "repub", required = false) boolean repub) {
        tom.setMsg(msg);
        if(repub){
            listenerBind.publish(tom);
        }else{
            // 以此测试事件每次发生变化时候，都需要重新发布。否则监听器监听不到。
        }
    }

    /**
     * localhost:8080/pig/configSec?msg="haha"
     * @param msg
     */
    @GetMapping(value = "/configSec")
    public void configSec(@RequestParam String msg) {
        sec.setMsg(msg);
        listenerBind.publish(sec);
    }
}
