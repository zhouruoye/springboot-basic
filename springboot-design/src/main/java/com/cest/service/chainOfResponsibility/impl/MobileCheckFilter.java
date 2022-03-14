package com.cest.service.chainOfResponsibility.impl;

import com.cest.pojo.SmsDTO;
import com.cest.service.chainOfResponsibility.MobileFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 手机格式校验
 */
@Order(2)
@Component
@Slf4j
public class MobileCheckFilter implements MobileFilter {

    //正则表达式
    private static final String REGEX =  "^((13[0-9])|(14[579])|(15([0-3,5-9]))|(16[6])|(17[0135678])|(18[0-9]|19[89]))\\d{8}$";

    @Override
    public boolean filter(SmsDTO smsDTO) {
        log.info("手机格式校验");
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(smsDTO.getMobile());
        if (matcher.matches()) {
            return true;
        }
        System.out.println("手机号有误");
        return false;
    }
}
