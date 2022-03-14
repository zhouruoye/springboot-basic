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
 * 从上⾯代码从if语句᯿构到使⽤责任链模式开发可以看到，我们的代码结构变得清晰⼲净了，也解
 * 决了⼤量if语句的使⽤。并不是if语句不好，只不过if语句并不适合做系统流程设计，但是在做判断
 * 和⾏为逻辑处理中还是⾮常可以使⽤的。
 * 在我们前⾯学习结构性模式中讲到过组合模式，它像是⼀颗组合树⼀样，我们搭建出⼀个流程决策
 * 树。其实这样的模式也是可以和责任链模型进⾏组合扩展使⽤，⽽这部分的᯿点在于如何关联链路
 * 的关联，最终的执⾏都是在执⾏在中间的关系链。
 * 责任链模式很好的处理单⼀职责和开闭原则，简单了耦合也使对象关系更加清晰，⽽且外部的调⽤
 * ⽅并不需要关⼼责任链是如何进⾏处理的(以上程序中可以把责任链的组合进⾏包装，在提供给外
 * 部使⽤)。但除了这些优点外也需要是适当的场景才进⾏使⽤，避免造成性能以及编排混乱调试测
 * 试疏漏问题。
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
