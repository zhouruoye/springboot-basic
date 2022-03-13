package com.cest.controller;

import com.cest.pojo.DemoPojo;
import com.cest.service.strategy.impl.SimpleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/strategy")
public class StrategyController {

    @Autowired
    private SimpleContext simpleContext;

    @PostMapping("/choose")
    public String choose(@RequestBody DemoPojo demoPojo){
        return simpleContext.getResource(demoPojo);
    }
}
