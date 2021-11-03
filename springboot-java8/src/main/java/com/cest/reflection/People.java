package com.cest.reflection;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

@Slf4j
public class People {
    public String name;
    protected Integer age;
    char type;
    private String targetInfo;

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

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String getTargetInfo() {
        return targetInfo;
    }

    public void setTargetInfo(String targetInfo) {
        this.targetInfo = targetInfo;
    }

    public static Logger getLog() {
        return log;
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

    //***************成员方法***************//
    public void show1(String s){
        System.out.println("调用了公有的，String参数的show1(): s = " + s);
    }
    protected void show2(){
        System.out.println("调用了受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了默认的，无参的show3()");
    }
    private String show4(int index){
        System.out.println("调用了私有的，并且有返回值的，int参数的show4(): index = " + index);
        return "show4result";
    }
}
