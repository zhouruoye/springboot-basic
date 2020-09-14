package com.cest.design.behavioral.chainofresponsibility.demo2;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by cestlavie on 2019/10/31.
 */
@Slf4j
public class VicePresident extends Approver {
    public VicePresident(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getAmount() <= 50000){
            log.info(
                    "\n副董事长:" + this.name +
                            "审批采购单号:" + request.getNumber() +
                            "采购金额:" + request.getAmount() +
                            "采购目的:" + request.getPurpose()
            );
        }else {
            super.approver.processRequest(request);
        }
    }
}
