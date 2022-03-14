package com.cest.service.adapter.impl;

import com.cest.service.adapter.OrderAdapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("pOPOrderAdapterServiceImpl")
public class POPOrderAdapterServiceImpl implements OrderAdapterService {

    @Autowired
    private POPOrderService popOrderService;

    @Override
    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }
}
