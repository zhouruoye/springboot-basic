package com.cest.design.structural.decorator.demo1;

public abstract class AbstractDecorator extends ABatterCake{

    private ABatterCake aBatterCake;

    public AbstractDecorator(ABatterCake aBatterCake) {
        this.aBatterCake = aBatterCake;
    }

    //编写自己的方法
    public abstract void doSomething();

    @Override
    public String getDes() {
        return aBatterCake.getDes();
    }

    @Override
    public int cost() {
        return aBatterCake.cost();
    }
}
