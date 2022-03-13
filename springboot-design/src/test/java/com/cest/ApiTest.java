package com.cest;

import com.cest.service.template.NetMall;
import com.cest.service.template.impl.DangDangNetMall;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ApiTest {

    /**
     * 测试链接
     * 京东；https://item.jd.com/100008348542.html
     * 淘宝；https://detail.tmall.com/item.htm
     * 当当；http://product.dangdang.com/1509704171.html
     */
    @Test
    public void test_NetMall() {
        NetMall netMall = new DangDangNetMall();
        String base64 = netMall.generateGoodsPoster("http://product.dangdang.com/1509704171.html");
        log.info("测试结果：{}", base64);
    }
}
