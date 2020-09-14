package com.cest.design.ctreational.prototype;

import java.util.Date;

/**
 * 原型模式
 * 深拷贝
 * Cloneable
 * Object提供了一个对象拷贝的默认方法clone方法，但是该方法是有缺陷的，它提供了一种浅拷贝方式，
 * 也就是它并不会把对象所有属性全部拷贝一份，而是有选择性的拷贝，拷贝规则如下：
 * 1、基本类型
 * 如果变量是基本类型，则拷贝其值，比如：int、float、long等。
 * 2、String字符串
 * 这个比较特殊，拷贝的是地址，是个引用，但是在修改的时候，它会从字符串池（String Pool）
 * 中重新生成新的字符串，原有的字符串对象保持不变，此处可以认为String是个基本类型。
 * 3、对象
 * 如果变量时一个实例对象，则拷贝地址引用，也就是说此时新拷贝出的对象与原有对象共享该实例变量，不受访问权限的限制。
 * 这在Java中很疯狂，因为它突破了访问权限的定义，一个private修饰的变量，竟然可以被两个实例对象访问。
 * 所以需要对成员进行拷贝 如果是对象 需要实现Cloneable接口
 */
public class Cat implements Cloneable{

    private String name;
    private Date birthday;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Cat cat = (Cat) super.clone();

        //深拷贝
        cat.birthday = (Date) cat.birthday.clone();

        return cat;
    }

    public Cat(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
