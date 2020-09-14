package com.cest.design.structural.decorator.demo1;

public class BatterCake extends ABatterCake {

    @Override
    public String getDes() {
        return "买一个煎饼";
    }

    @Override
    public int cost() {
        return 5;
    }
}
