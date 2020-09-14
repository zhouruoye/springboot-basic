package com.cest.behavioral.chainofresponsibility.r1;

/**
 * Created by cestlavie on 2019/10/25.
 */
public class Test {

    public static void main(String[] args) {
        Course course = new Course();
        course.setName("张三");
        course.setVideo("视频");
        course.setArticle("手记");

        Approver articleApprover = new ArticleApprover();
        Approver videoApprover = new VideoApprover();

        videoApprover.setNextApprover(articleApprover);

        videoApprover.chkCourse(course);

    }
}
