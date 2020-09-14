package com.cest.behavioral.chainofresponsibility.r1;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by cestlavie on 2019/10/25.
 */
@Slf4j
public class VideoApprover extends Approver {
    @Override
    public void chkCourse(Course course) {
        if(StringUtils.isNotEmpty(course.getVideo())){
            log.info("{}的课程含有视频信息,视频检测通过",course.getName());
            if(super.approver != null){
                super.approver.chkCourse(course);
            }
        }else {
            log.info("没有视频信息,检测不通过");
            return;
        }
    }
}
