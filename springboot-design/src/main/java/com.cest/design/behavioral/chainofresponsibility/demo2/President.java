package com.cest.design.behavioral.chainofresponsibility.demo2;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by cestlavie on 2019/11/1.
 */
@Slf4j
public class President extends Approver {

    public President(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getAmount() <= 80000){
            log.info(
                    "\n董事长:" + this.name +
                            "审批采购单号:" + request.getNumber() +
                            "采购金额:" + request.getAmount() +
                            "采购目的:" + request.getPurpose()
            );
        }else {
            super.approver.processRequest(request);
        }
    }
}
