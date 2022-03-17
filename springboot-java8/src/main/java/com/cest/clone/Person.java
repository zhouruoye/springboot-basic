package com.cest.clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable,Cloneable {

    private static final long serialVersionUID = -9102017020286042305L;
    private String name; // 姓名

    private int age; // 年龄

    private Car car; // 座驾

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
class Car implements Serializable {
    private static final long serialVersionUID = -5713945027627603702L;
    private String brand; // 品牌
    private int maxSpeed; // 最高时速
}
