package com.cest.service.strategy.impl;

import com.cest.pojo.DemoPojo;
import com.cest.service.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("unionPay")
public class UnionPay implements PayStrategy {
    @Override
    public String getVpcList(DemoPojo demoPojo) {
        log.info("unionPay");
        return demoPojo.getName();
    }
}
