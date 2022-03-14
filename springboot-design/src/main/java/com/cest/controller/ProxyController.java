package com.cest.controller;


import com.cest.design.structural.proxy.demo2.entity.Empe;
import com.cest.service.proxy.EmpeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 代理模式
 */
@RestController
@RequestMapping(value = "/api/proxy/", produces = "application/json;charset=utf-8")
public class ProxyController {

    @Qualifier("empeProxy")
    @Autowired
    private EmpeService empeService;

    @PostMapping("/send")
    public String send(@RequestParam("id") String id) {
        empeService.addOneEmpe(Empe.builder()
                .empeId(id)
                .age(20)
                .name("张三")
                .build());

        empeService.deleteEmpeById(id);
        return "success";
    }

}
