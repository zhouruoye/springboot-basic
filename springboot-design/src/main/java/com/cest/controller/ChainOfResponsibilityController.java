package com.cest.controller;


import com.cest.pojo.SmsDTO;
import com.cest.service.chainOfResponsibility.impl.SmsSendFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 责任链模式
 */
@RestController
@RequestMapping(value = "/api/chainOfResponsibility/", produces = "application/json;charset=utf-8")
public class ChainOfResponsibilityController {

    @Autowired
    private SmsSendFactory smsSendFactory;

    @PostMapping("/send")
    public String send(@RequestParam("mobile") String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return "mobile is null";
        }

        String code = Double.toString((Math.random() * 9) * 1000);
        SmsDTO smsDTO = SmsDTO.builder()
                .mobile(mobile)
                .verificationCode(code)
                .build();
        if (!smsSendFactory.check(smsDTO)) {
            return "fail";
        }
        return "success";
    }
}
