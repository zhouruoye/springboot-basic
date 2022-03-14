package com.cest.service.chainOfResponsibility;

import com.cest.pojo.SmsDTO;

/**
 * 短信发送；有很多规则，例如：开关、发送次数、黑名单、手机格式校验等等。
 *   现在，下面基于这种场景来实现过滤式责任链，如果不使用责任链，就会产生很多if else存在，并且下次要添加新的规则，需要改动原来的代码，不符合开闭原则。
 *   这里为了演示，实现起来会比较简单，重点是要理解责任链这个东西的使用方法。
 * 构建一个拦截器
 */
public interface MobileFilter {

    boolean filter(SmsDTO smsDTO);

}
