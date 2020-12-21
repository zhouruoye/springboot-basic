package com.cest.nullpointAndEx;

import com.cest.erenum.StaffType;
import com.google.common.base.Enums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 常见异常
 * 1 可迭代对象在遍历的同时做修改，则会报并发修改异常
 * 2 类型转换不符合Java的继承关系，则会报类型转换异常
 * 3 枚举在查找时，如果枚举值不存在，不会返回空，而是直接抛出异常
 */
@Slf4j
public class GeneralException {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User {
        private String name;
    }

    public static class Student extends User {

    }

    public static class Teacher extends User {

    }

    public static final Map<String,StaffType> mapStaffType = new HashMap<>();

    static {
        for (StaffType value : StaffType.values()) {
            mapStaffType.put(value.name(),value);
        }
    }

    public static StaffType findEnum(String type) {
//        return StaffType.valueOf(type);

        // 解决方法
        // 1 try-catch
//        try {
//            return StaffType.valueOf(type);
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//            log.info("-------enter IllegalArgumentException-------");
//            return null;
//        }

        // 2 遍历
//        for (StaffType value : StaffType.values()) {
//            if(value.name().equals(type)) {
//                return value;
//            }
//        }
//        return null;

        // 3 静态map 只有一次循环map的过程
//        return mapStaffType.get(type);

        // 4 google guava enums 需要相关的依赖
        return Enums.getIfPresent(StaffType.class,type).orNull();
    }

    /**
     * 可迭代对象在遍历的同时做修改，则会报并发修改异常
     */
    private static void concurrentModificationException() {
        List<User> users = new ArrayList<>();
        User user1 = new User("张三");
        User user2 = new User("李四");
        users.add(user1);
        users.add(user2);

//        fail-fast机制 迭代器创建后会建立一个指向原对象的索引表 直接迭代concurrentModificationException
//        for (User user : users) {
//            if("李四".equals(user.getName())) {
//                log.info("--------------------");
//                users.remove(user);
//            }
//        }

        // 解决方法使用迭代器
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User next = iterator.next();
            if("李四".equals(next.getName())) {
                log.info("--------------------");
                users.remove(next);
            }
        }
    }

    /**
     * 类型转换异常
     */
    public static void classCastException() {
        User user1 = new Student();
        User user2 = new Teacher();

        Student student1 = (Student)user1;
        Student student2 = (Student)user2;

//      解决方法
        System.out.println(user1.getClass().getName());
        System.out.println(user2 instanceof Student);
    }


    public static void unException() {
        findEnum("g");
    }

    public static void main(String[] args) {
//        concurrentModificationException();
//        classCastException();
        unException();
    }
}
