package com.cest.service.chainOfResponsibility.impl;

import com.cest.pojo.SmsDTO;
import com.cest.service.chainOfResponsibility.MobileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 短信发送工厂
 */
@Component
public class SmsSendFactory {

    @Autowired
    private List<MobileFilter> filters;

    /**
     * 校验手机号
     * @param smsDTO
     * @return
     */
    public boolean check(SmsDTO smsDTO) {
        for (MobileFilter filter : filters) {
            if (!filter.filter(smsDTO)) {
                return false;
            }
        }
        return true;
    }
}
