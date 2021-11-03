package com.cest.reflection;

import com.cest.entity.Boy;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射获取的三种形式
 */
@Slf4j
public class Demo1 {

    void test() throws ClassNotFoundException {
        Boy boy = new Boy("tom", 12);

        Class aClass = boy.getClass();

        Class boyClass = Boy.class;

        Class aClass1 = Class.forName("com.cest.entity.Boy");

        System.out.println(aClass == boyClass);
        System.out.println(aClass == aClass1);

        for (int i = 0; ++i < 5; ) {
            System.out.println(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        opConstructor();
//        opField();
        opMethod();
    }

    public static void opMethod() {
        try {
            Class aClass = Class.forName("com.cest.reflection.People");
            log.info("------------------------获取全部公共方法-------------------------");
            Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

            log.info("------------------------获取全部方法（包括私有的）-------------------------");
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                System.out.println(declaredMethod);
            }
            log.info("------------------------获取公共方法-------------------------");
            Method show1 = aClass.getMethod("show1", String.class);
            People people = (People) aClass.getConstructor().newInstance();
            show1.invoke(people, "我是show1方法");

            log.info("------------------------获取方法（包括私有的）-------------------------");
            Method show4 = aClass.getDeclaredMethod("show4", int.class);
            show4.setAccessible(true);
            show4.invoke(people,123131);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void opField() {
        try {
            Class aClass = Class.forName("com.cest.reflection.People");
            log.info("------------------------获取全部公共成员变量-------------------------");
            Field[] fields = aClass.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            log.info("------------------------获取全部公共成员变量（包括私有的）-------------------------");
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                System.out.println(declaredField);
            }

            log.info("----------------------------获取公有字段并调用-----------------------------");
            Field name = aClass.getField("name");
            People o = (People) aClass.getConstructor().newInstance();
            name.set(o, "小花");
            log.info("当前people的名字是：{}", o.name);

            log.info("----------------------------获取私有字段并调用-----------------------------");
            Field targetInfo = aClass.getDeclaredField("targetInfo");
            targetInfo.setAccessible(true);
            targetInfo.set(o, "目标信息");
            log.info("当前people的信息是：{}", o.getTargetInfo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void opConstructor() {
        Class aClass = null;
        try {
            aClass = Class.forName("com.cest.reflection.People");
            Constructor[] constructors = aClass.getConstructors();

            log.info("------------------------获取全部公有构造方法-------------------------");
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }

            log.info("-------------------------获取全部构造方法--------------------------");
            Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
            for (Constructor declaredConstructor : declaredConstructors) {
                System.out.println(declaredConstructor);
            }

            log.info("--------------------------根据类型获取构造方法------------------------------");
            Constructor constructor = aClass.getConstructor(String.class, String.class);
            People people1 = (People) constructor.newInstance("123", "123");

            log.info("----------------------------根据类型获取构造方法(包括私有的)---------------------------");
            Constructor declaredConstructor2 = aClass.getDeclaredConstructor(String.class);
            declaredConstructor2.setAccessible(true);
            People people3 = (People) declaredConstructor2.newInstance("123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
