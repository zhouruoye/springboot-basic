package com.cest.behavioral.chainofresponsibility.r1;

/**
 * Created by cestlavie on 2019/10/25.
 */
public abstract class Approver {

    protected Approver approver;

    public void setNextApprover(Approver approver){
        this.approver = approver;
    }

    public abstract void chkCourse(Course course);
}
