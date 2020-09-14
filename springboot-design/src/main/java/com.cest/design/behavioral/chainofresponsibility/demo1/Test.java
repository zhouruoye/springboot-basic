package com.cest.design.behavioral.chainofresponsibility.demo1;

/**
 * 很多情况下，在一个软件系统中可以处理某个请求的对象不止一个，例如SCM系统中的采购单审批，主任、副董事长、董事长和
 * 董事会都可以处理采购单，他们可以构成一条处理采购单的链式结构，采购单沿着这条链进行传递，这条链就称为职责链。职责
 * 链可以是一条直线、一个环或者一个树形结构，最常见的职责链是直线型，即沿着一条单向的链来传递请求。链上的每一个对象
 * 都是请求处理者，职责链模式可以将请求的处理者组织成一条链，并让请求沿着链传递，由链上的处理者对请求进行相应的处理，
 * 客户端无须关心请求的处理细节以及请求的传递，只需将请求发送到链上即可，实现请求发送者和请求处理者解耦。
 *
 * 职责链模式(Chain of Responsibility Pattern)：避免请求发送者与接收者耦合在一起，让多个对象都有可能接收请求，将这
 * 些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。职责链模式是一种对象行为型模式。
 */
public class Test {

    public static void main(String[] args) {
        Approver articleApprover = new ArticleApprover();
        Approver sourceApprover = new SourceApprover();
        Approver videoApprover = new VideoApprover();

        //    实例化对象
        Course course = new Course();
        course.setArticle("手记");
        course.setName("张三");
        course.setSource("源码");
        course.setVedio("视频");

        sourceApprover.setNextApprover(videoApprover);
        articleApprover.setNextApprover(sourceApprover);

        articleApprover.chkCourse(course);
    }
}
