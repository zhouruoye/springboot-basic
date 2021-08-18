package com.cest.design.ctreational.builder.course;

/**
 * 课程类
 * Created by cestlavie on 2019/10/16.
 */
public class Course {

    //课程名称
    private String courseName;

    //课程PPT
    private String coursePPT;

    //课程视频
    private String courseVideo;

    public Course() {
    }

    public Course(CourseBuilder courseBuilder) {
        this.courseName = courseBuilder.courseName;
        this.coursePPT = courseBuilder.coursePPT;
        this.courseVideo = courseBuilder.courseVideo;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", coursePPT='" + coursePPT + '\'' +
                ", courseVideo='" + courseVideo + '\'' +
                '}';
    }

    public static class CourseBuilder {
        private String courseName;
        private String coursePPT;
        private String courseVideo;

        public CourseBuilder builderCourseName(String courseName){
            this.courseName = courseName;
            return this;
        }

        public CourseBuilder builderCoursePPT(String coursePPT){
            this.coursePPT = coursePPT;
            return this;
        }

        public CourseBuilder builderCourseVideo(String courseVideo){
            this.courseVideo = courseVideo;
            return this;
        }

        public Course build(){
            return new Course(this);
        }
    }
}
