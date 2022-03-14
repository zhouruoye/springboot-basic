package com.cest.controller;


import com.cest.design.structural.proxy.demo2.cglibproxy.CglibProxy;
import com.cest.design.structural.proxy.demo2.dynamicproxy.DynamicProxyHandler;
import com.cest.design.structural.proxy.demo2.entity.Empe;
import com.cest.service.proxy.EmpeService;
import com.cest.service.proxy.impl.EmpeServiceImpl;
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

    @Qualifier("empeServiceImpl")
    @Autowired
    private EmpeService empeServiceImpl;

    @Autowired
    private CglibProxy cglibProxy;

    @Autowired
    private DynamicProxyHandler dynamicProxyHandler;

    @PostMapping("/cglibProxy")
    public String cglibProxy(@RequestParam("id") String id) {
        EmpeServiceImpl instance = (EmpeServiceImpl) cglibProxy.getInstance(empeServiceImpl);
        instance.deleteEmpeById("1111");
        return "success";
    }

    @PostMapping("/dynamicProxyHandler")
    public String dynamicProxyHandler(@RequestParam("id") String id) {
        EmpeService instance = (EmpeService) dynamicProxyHandler.bind(empeServiceImpl);
        instance.deleteEmpeById("1111");
        return "success";
    }


    @PostMapping("/staticProxy")
    public String staticProxy(@RequestParam("id") String id) {
        empeService.addOneEmpe(Empe.builder()
                .empeId(id)
                .age(20)
                .name("张三")
                .build());

        empeService.deleteEmpeById(id);
        return "success";
    }

}
