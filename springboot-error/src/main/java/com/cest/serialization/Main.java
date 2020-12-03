package com.cest.serialization;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class Main {

    //实现序列化和反序列化
    private static void testSerializationWithPeople() throws Exception {

        //创建文件
        File file = new File("/home/tmp/people.java");
        People people = new People("123");

        //创建输出流
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(people);
        }

        //读取文件
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            Object o = objectInputStream.readObject();
            System.out.println(o);
        }
    }

    //子类实现序列化, 父类不实现序列化 实现无参的构造函数 可以实现序列化
    private static void testSerizableWithStudent() throws Exception {

        //创建文件
        File file = new File("/home/tmp/student.java");
        MidStudent midStudent = new MidStudent("1111", "2222");

        //创建输出流
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(midStudent);
        }

        //读取文件
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            Object o = objectInputStream.readObject();
            System.out.println(o);
        }
    }

    //引用对象没有实现序列化 无法实现序列化
    private static void testSerizableWithQuote() throws Exception {

        File file = new File("/home/tmp/quote.java");
        Quote quote = new Quote("2w1321",new Student("1"));
         //创建输出流
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(quote);
        }

        //读取文件
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            Object o = objectInputStream.readObject();
            System.out.println(o);
        }

    }

    /**
     * <h2>同一个对象多次序列化的问题, 坑</h2> 已经序列化的不会重复序列化
     * */
    private static void sameObjectRepeatedSerialization() throws Exception {

        File file = new File("/home/tmp/peopele_more.java_");
        People p = new People("10");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

        oos.writeObject(p);
        oos.writeObject(p);

        p.setId("20");
        oos.writeObject(p);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object people1 = ois.readObject();
        Object people2 = ois.readObject();
        Object people3 = ois.readObject();
//        Object people4 = ois.readObject();
        ois.close();

        System.out.println(((People) people1).getId());
        System.out.println(((People) people2).getId());
        System.out.println(((People) people3).getId());
//        System.out.println(((People) people4).getId());
    }

    public static void main(String[] args) throws Exception {
//        testSerializationWithPeople();

//        testSerizableWithStudent();

//        testSerizableWithQuote();

        sameObjectRepeatedSerialization();
    }
}
