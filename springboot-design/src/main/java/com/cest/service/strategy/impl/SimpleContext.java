package com.cest.service.strategy.impl;

import com.cest.pojo.DemoPojo;
import com.cest.service.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 通过Spring将实现Strategy的实现类都自动注入到strategyMap类中，
 * 当用户传入选择的资源池时，自动根据资源池id去对应的资源池实现中查找资源。
 */
@Service
@Slf4j
public class SimpleContext {

    @Autowired
    private final Map<String, PayStrategy> strategyMap = new ConcurrentHashMap<>();

    public SimpleContext(Map<String, PayStrategy> strategyMap) {
        this.strategyMap.clear();
        strategyMap.forEach((k, v)-> this.strategyMap.put(k, v));
        log.info("策略模式");
    }

    public String getResource(DemoPojo demoPojo){
        return strategyMap.get(demoPojo.getPoolid()).getVpcList(demoPojo);
    }
}
