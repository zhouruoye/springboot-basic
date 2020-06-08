package com.cest.threadlocal.threadlocal;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;

/**
 * initialValue适用于已知的类 直接实例化
 */
@Slf4j
public class ThreadSimpledateformat {

    /**
     * 写法1
     */
    public static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    /**
     * 写法2
     */
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal2 = ThreadLocal
            .withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

}