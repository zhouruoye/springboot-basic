package com.cest.design.behavioral.chainofresponsibility.demo2;

/**
 * 审批抽象类
 * Created by cestlavie on 2019/10/31.
 */
public abstract class Approver {

    protected Approver approver;

    protected String name;

    public Approver(String name) {
        this.name = name;
    }

    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    //抽象请求处理方法
    public abstract void processRequest(PurchaseRequest request);
}
