package com.cest.controller;

import com.cest.service.template.NetMall;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模板模式
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/template/", produces = "application/json;charset=utf-8")
public class TemplateController {


    @Autowired
    private ApplicationContext applicationContext;

    @PostMapping("/geturl")
    public String geturl(@RequestParam("url") String url,@RequestParam("targetName") String targetName) {
        log.info("---------------发送url-------------", url);
        String uId = "zhangsan";
        String pwd = "123456";
        /**
         * 使用applicationContext 工厂模式 避免注入多个bean
         */
        NetMall netMall = (NetMall)applicationContext.getBean(targetName);
        netMall.generateGoodsPoster(url, uId, pwd);
//        taoBaoNetMall.generateGoodsPoster(url, uId, pwd);
        return "success";
    }
}
