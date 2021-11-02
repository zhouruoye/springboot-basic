package com.cest.reflection;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class People {

    private String name;

    private Integer age;

    public People(String name, String haha) {
        log.info("String 类型的构造方法");
        this.name = name;
    }

    public People() {
    }

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private People(String name) {
        log.info("我是私有构造方法");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
