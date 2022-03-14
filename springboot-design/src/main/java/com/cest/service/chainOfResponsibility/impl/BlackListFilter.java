package com.cest.service.chainOfResponsibility.impl;

import com.cest.pojo.SmsDTO;
import com.cest.service.chainOfResponsibility.MobileFilter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @projectName: spring-chain-demo
 * @className: BlackListFilter
 * @description:手机黑名单过滤
 **/
@Slf4j
@Component
@Order(3)
public class BlackListFilter implements MobileFilter {

    @Autowired
    private Environment environment;

    @Override
    public boolean filter(SmsDTO smsDTO) {
        log.info("手机黑名单校验");
        String mobile = environment.getProperty("mobile.black.list");
        if (StringUtils.isEmpty(mobile)) {
            return true;
        }
        if (mobile.equals(smsDTO.getMobile())) {
            System.out.println("手机号在黑名单中");
            return false;
        }
        return true;
    }
}
