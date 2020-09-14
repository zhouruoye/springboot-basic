package com.cest.design.structural.decorator.demo1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {

    public static void main(String[] args) {
        ABatterCake aBatterCake = new BatterCake();
        //加两个鸡蛋
        aBatterCake = new EggDecorator(aBatterCake);
        aBatterCake = new EggDecorator(aBatterCake);

        //加一个鸡排
        aBatterCake = new ChkLegDecorator(aBatterCake);


        log.info("{},销售价格为:{}",aBatterCake.getDes(),aBatterCake.cost());
    }
}
