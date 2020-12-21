package com.cest.design.ctreational.abstractfactory;

/**
 * Created by cestlavie on 2019/10/16.
 */
public class JavaCourseFactory implements CourseFactory {

    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Source getSource() {
        return new JavaSource();
    }
}
