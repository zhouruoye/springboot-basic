package com.cest.design.structural.proxy.demo2.cglibproxy;

import com.cest.design.structural.proxy.demo2.component.EmpeServiceImpl;

/**
 * Created by cestlavie on 2019/11/14.
 */
public class Test {

    public static void main(String[] args) {
        EmpeServiceImpl empeService = new EmpeServiceImpl();

        CglibProxy cglibProxy = new CglibProxy();
        EmpeServiceImpl instance = (EmpeServiceImpl) cglibProxy.getInstance(empeService);
        instance.deleteEmpeById("1111");
    }
}
