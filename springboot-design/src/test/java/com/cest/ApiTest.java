package com.cest;

import com.cest.service.adapter.OrderAdapterService;
import com.cest.service.adapter.impl.InsideOrderServiceImpl;
import com.cest.service.adapter.impl.POPOrderAdapterServiceImpl;
import com.cest.service.template.NetMall;
import com.cest.service.template.impl.DangDangNetMall;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ApiTest {

    /**
     * 测试链接
     * 京东；https://item.jd.com/100008348542.html
     * 淘宝；https://detail.tmall.com/item.html
     * 当当；http://product.dangdang.com/1509704171.html
     */
    @Test
    public void test_NetMall() {
        NetMall netMall = new DangDangNetMall();
        String base64 = netMall.generateGoodsPoster("http://product.dangdang.com/1509704171.html","zhangsan","123456");
        log.info("测试结果：{}", base64);
    }


    @Test
    public void test_itfAdapter() {
        OrderAdapterService popOrderAdapterService = new POPOrderAdapterServiceImpl();
        System.out.println("判断首单，接口适配(POP)：" + popOrderAdapterService.isFirst("100001"));

        OrderAdapterService insideOrderService = new InsideOrderServiceImpl();
        System.out.println("判断首单，接口适配(自营)：" + insideOrderService.isFirst("100001"));
    }

}
