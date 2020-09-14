package com.cest.design.structural.decorator.demo1;

public class ChkLegDecorator extends AbstractDecorator{

    public ChkLegDecorator(ABatterCake aBatterCake) {
        super(aBatterCake);
    }

    @Override
    public void doSomething() {

    }

    @Override
    public String getDes() {
        return super.getDes() + ",我想加一个鸡排";
    }

    @Override
    public int cost() {
        return super.cost() + 5;
    }
}
