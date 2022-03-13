package com.cest.controller;

import com.cest.pojo.DemoPojo;
import com.cest.service.strategy.impl.SimpleContext;
import com.cest.service.template.NetMall;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Slf4j
@RestController("/template")
public class TemplateController {

    @Autowired
    private NetMall dangDangNetMall;

    @PostMapping("/geturl")
    public String geturl(@RequestBody DemoPojo demoPojo){
        dangDangNetMall.generateGoodsPoster(demoPojo.getPoolid());
        return "success";
    }
}
