package com.cest.design.behavioral.chainofresponsibility.demo2;

/**
 * Created by cestlavie on 2019/10/31.
 */
public class Test {

    public static void main(String[] args) {
        Approver wjzhang,gyang,wslu;
        wjzhang = new Director("张无忌");
        gyang = new VicePresident("杨过");
        wslu = new President("陆无双");
        wjzhang.setApprover(gyang);
        gyang.setApprover(wslu);
        //创建采购单
        PurchaseRequest pr1 = new PurchaseRequest(5000,10001,"购买倚天剑");
        wjzhang.processRequest(pr1);

        PurchaseRequest pr2 = new PurchaseRequest(40000,10002,"购买《葵花宝典》");
        wjzhang.processRequest(pr2);

        PurchaseRequest pr3 = new PurchaseRequest(80000,10003,"购买碧血剑");
        wjzhang.processRequest(pr3);
    }
}
