package com.cest.design.structural.decorator.demo1;

public class EggDecorator extends AbstractDecorator {

    public EggDecorator(ABatterCake aBatterCake) {
        super(aBatterCake);
    }

    @Override
    public void doSomething() {

    }

    @Override
    public String getDes() {
        return super.getDes() + ",我想加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
