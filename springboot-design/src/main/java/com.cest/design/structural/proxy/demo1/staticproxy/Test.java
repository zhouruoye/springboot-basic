package com.cest.design.structural.proxy.demo1.staticproxy;

import com.cest.design.structural.proxy.demo1.component.Order;

public class Test {

    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);

        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
        orderServiceStaticProxy.saveOrder(order);
    }
}
