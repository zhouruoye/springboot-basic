package com.cest.design.ctreational.abstractfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by cestlavie on 2019/10/16.
 */
@Slf4j
public class JavaSource extends Source {

    @Override
    public void getSource() {
        log.info("获取Java源码");
    }
}
