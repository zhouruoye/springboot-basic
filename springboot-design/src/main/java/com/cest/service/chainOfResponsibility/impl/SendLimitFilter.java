package com.cest.service.chainOfResponsibility.impl;

import com.cest.pojo.SmsDTO;
import com.cest.service.chainOfResponsibility.MobileFilter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 短信发送次数限制
 */
@Order(4)
@Service
@Slf4j
public class SendLimitFilter implements MobileFilter {

    @Autowired
    private Environment environment;
    // 模拟短信发送次数缓存
    private Map<String,Integer> smsSendMap = new ConcurrentHashMap<>();

    @Override
    public boolean filter(SmsDTO smsDTO) {
        log.info("短信次数校验");
        String num = environment.getProperty("send.frequency.limit");
        if(StringUtils.isEmpty(num)){//没有限制条件
            return true;
        }
        Integer mobileNum = smsSendMap.get(smsDTO.getMobile());

        if(mobileNum != null && Integer.parseInt(num) <= mobileNum){
            System.out.println("手机号已被限制");
            return false;
        }
        if(mobileNum == null){
            smsSendMap.put(smsDTO.getMobile(),new Integer(1));
        }else{
            smsSendMap.put(smsDTO.getMobile(),new Integer(mobileNum) + 1);
        }
        return true;

    }
}
