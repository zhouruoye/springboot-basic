package com.cest.design.behavioral.chainofresponsibility.demo1;

/**
 * 批准抽象类
 */
public abstract class Approver {

    protected Approver approver;

    public void setNextApprover(Approver approver){
        this.approver = approver;
    }

    //建立一个检查课程的抽象类 由子类实现
    public abstract void chkCourse(Course course);
}
