package com.cest.design.structural.proxy.demo1.staticproxy;

import com.cest.design.structural.proxy.demo1.component.IOrderService;
import com.cest.design.structural.proxy.demo1.component.Order;
import com.cest.design.structural.proxy.demo1.component.OrderServiceImpl;
import com.cest.design.structural.proxy.demo1.db.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;

/**
 * 模仿aop
 */
@Slf4j
public class OrderServiceStaticProxy {

    private IOrderService orderService;

    public int saveOrder(Order order){
        beforeMethod(order);
        orderService = new OrderServiceImpl();
        int result = orderService.saveOrder(order);
        afterMethod();
        return result;
    }

    private void beforeMethod(Order order){
        Integer userId = order.getUserId();
        int dbRouter = userId % 2;
        log.info("静态代理分配到 db "+ dbRouter +" 处理数据");

        DataSourceContextHolder.setDBType("db"+String.valueOf(dbRouter));
        log.info("静态代理 before code");
    }

    private void afterMethod(){
        log.info("静态代理 after code");
    }



}
