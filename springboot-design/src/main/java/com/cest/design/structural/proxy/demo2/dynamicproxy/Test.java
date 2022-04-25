package com.cest.design.structural.proxy.demo2.dynamicproxy;

import com.cest.design.structural.proxy.demo2.component.EmpeService;
import com.cest.design.structural.proxy.demo2.component.EmpeServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * 动态代理测试类
 * Created by cestlavie on 2019/11/14.
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        EmpeService empeService = new EmpeServiceImpl();

        EmpeService empeService1 = (EmpeService)new DynamicProxyHandler(empeService).bind();
        empeService1.deleteEmpeById("1111");


//        empeService1.addOneEmpe(Empe.builder()
//                .empeId("123")
//                .name("张三")
//                .age(13)
//                .build());
    }
}
