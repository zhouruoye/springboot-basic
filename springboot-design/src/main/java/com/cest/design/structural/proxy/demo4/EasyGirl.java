package com.cest.design.structural.proxy.demo4;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EasyGirl implements Person{
    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
    }
}
