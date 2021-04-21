package com.cest.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


@ToString
@Data
@Slf4j
public class User {
    private String id;

    //finalize 在地址对象回收的时候调用
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        log.info("now finalize id:{}",id);
    }
}
