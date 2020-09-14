package com.cest.design.behavioral.chainofresponsibility.demo1;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * 检查源码情况
 */
@Slf4j
public class SourceApprover extends Approver {
    @Override
    public void chkCourse(Course course) {
        if(StringUtils.isNotEmpty(course.getSource())){
            log.info("{}的课程源码验证成功",course.getName());
            if(super.approver != null){
                super.approver.chkCourse(course);
            }
        }else {
            log.info("{}的课程源码验证失败",course.getName());
            return;
        }
    }


}
