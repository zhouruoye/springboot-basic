package com.cest.reflection;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

@Slf4j
public class ReflectionIssueApplication {

    private void age(int age) {
        log.info("int age = {}", age);
    }

    private void age(Integer age) {
        log.info("Integer age = {}", age);
    }

    public static void main(String[] args) {
        ReflectionIssueApplication ref = new ReflectionIssueApplication();
//        ref.age(10);
//        ref.age(Integer.valueOf(10));

        Class<? extends ReflectionIssueApplication> aClass = ref.getClass();

        try {
            Method age = aClass.getDeclaredMethod("age", Integer.class);

            ReflectionIssueApplication people = (ReflectionIssueApplication) aClass.getConstructor().newInstance();

            age.invoke(people,36);
            age.invoke(people,36);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
