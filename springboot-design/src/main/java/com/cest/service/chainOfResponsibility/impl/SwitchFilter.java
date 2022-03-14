package com.cest.service.chainOfResponsibility.impl;

import com.cest.pojo.SmsDTO;
import com.cest.service.chainOfResponsibility.MobileFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 构建一个开关拦截器
 */
@Order(1)
@Component
@Slf4j
public class SwitchFilter implements MobileFilter {

    @Autowired
    private Environment environment;

    //是否发送短信
    private static final String SWITCH_FLAG = "Y";

    @Override
    public boolean filter(SmsDTO smsDTO) {
        log.info("短信开关");
        if (SWITCH_FLAG.equals(environment.getProperty("switch.flag"))) {
            return true;
        }
        System.out.println("短信发送通道已关闭");
        return false;
    }
}
