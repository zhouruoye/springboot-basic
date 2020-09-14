package com.cest.behavioral.chainofresponsibility.r1;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by cestlavie on 2019/10/25.
 */
@Slf4j
public class ArticleApprover extends Approver {
    @Override
    public void chkCourse(Course course) {
        if(StringUtils.isNotEmpty(course.getArticle())){
            log.info("{}的课程含有手记信息,手记检测通过",course.getName());
            if(super.approver != null){
                super.approver.chkCourse(course);
            }
        }else {
            log.info("没有手记信息,检测不通过");
            return;
        }
    }
}
