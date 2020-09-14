package com.cest.design.behavioral.chainofresponsibility.demo2;

import lombok.extern.slf4j.Slf4j;

/**
 * 主任的审批权限 <= 10000元
 * Created by cestlavie on 2019/10/31.
 */
@Slf4j
public class Director extends Approver {

    public Director(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getAmount() <= 10000){
            log.info(
                    "\n主任:" + this.name +
                    "审批采购单号:" + request.getNumber() +
                    "采购金额:" + request.getAmount() +
                    "采购目的:" + request.getPurpose()
            );
        }else {
            super.approver.processRequest(request);
        }
    }
}
