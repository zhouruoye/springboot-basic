package com.cest.design.ctreational.abstractfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by cestlavie on 2019/10/16.
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Source source = courseFactory.getSource();
        Video video = courseFactory.getVideo();
        source.getSource();
        video.transcribeVideo();
    }

}
