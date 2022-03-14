package com.cest.service.adapter.impl;

import com.cest.service.adapter.OrderAdapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("insideOrderServiceImpl")
public class InsideOrderServiceImpl implements OrderAdapterService {

    @Autowired
    private OrderService orderService;

    @Override
    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }
}
