package com.cest.controller;

import com.cest.service.adapter.OrderAdapterService;
import com.cest.service.template.NetMall;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/adapter/", produces = "application/json;charset=utf-8")
public class AdapterController {

    @Qualifier("insideOrderServiceImpl")
    @Autowired
    private OrderAdapterService orderAdapterService;

    @PostMapping("/getuid")
    public String getuid(@RequestParam("uid") String uid) {
        orderAdapterService.isFirst(uid);
        return "success";
    }

}
