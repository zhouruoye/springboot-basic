package com.cest.clone;

public class CloneTest {

    public static void main(String[] args) {
        try {
            Car benz = new Car("Benz", 300);
            Person p1 = new Person("Hao LUO", 33, benz);
            Person p2 = MyUtil.clone(p1);
//            Person p2 = (Person)p1.clone();
            p2.getCar().setBrand("BYD");
            // 修改克隆的 Person 对象 p2 关联的汽车对象的品牌属性
            // 原来的 Person 对象 p1 关联的汽车不会受到任何影响
            // 因为在克隆 Person 对象时其关联的汽车对象也被克隆了
            System.out.println(p1);
            System.out.println(p2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
