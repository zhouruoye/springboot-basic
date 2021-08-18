package com.cest.design.ctreational.builder.course;

/**
 * Created by cestlavie on 2019/10/16.
 */
public class Test {
    public static void main(String[] args) {
        Course course = new Course.CourseBuilder()
                .builderCoursePPT("Java设计模式精讲PPT")
                .builderCourseName("Java设计模式精讲视频")
                .builderCourseVideo("Java设计模式精讲视频")
                .build();

        System.out.println(course);
    }
}
