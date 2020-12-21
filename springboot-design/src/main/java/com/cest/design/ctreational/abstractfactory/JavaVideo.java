package com.cest.design.ctreational.abstractfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by cestlavie on 2019/10/16.
 */
@Slf4j
public class JavaVideo extends Video {

    @Override
    public void transcribeVideo() {
        log.info("录制java视频");
    }
}
