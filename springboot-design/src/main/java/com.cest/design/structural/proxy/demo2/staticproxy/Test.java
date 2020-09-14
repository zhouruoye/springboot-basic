package com.cest.design.structural.proxy.demo2.staticproxy;

import com.cest.design.structural.proxy.demo2.component.EmpeService;
import com.cest.design.structural.proxy.demo2.component.EmpeServiceImpl;

/**
 * 优点：可以做到在符合开闭原则的情况下对目标对象进行功能扩展。
 * 缺点：我们得为每一个服务都得创建代理类，工作量太大，不易管理。
 * 同时接口一旦发生改变，代理类也得相应修改。
 * Created by cestlavie on 2019/11/14.
 */
public class Test {

    public static void main(String[] args) {
        EmpeService empeService = new EmpeServiceImpl();

        EmpeService empeServiceProxy = new EmpeProxy(empeService);
        empeServiceProxy.deleteEmpeById("122331211");

    }
}
