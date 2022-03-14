package com.cest.controller;

import com.cest.service.template.NetMall;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/template/", produces = "application/json;charset=utf-8")
public class TemplateController {

    @Autowired
    private NetMall dangDangNetMall;

    @PostMapping("/geturl")
    public String geturl(@RequestParam("url") String url) {
        log.info("---------------发送url-------------", url);
        String uId = "zhangsan";
        String pwd = "123456";
        dangDangNetMall.generateGoodsPoster(url, uId, pwd);
        return "success";
    }
}
