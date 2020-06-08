package com.cest.threadlocal.simpledateformat;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 版本1
 * 两个线程使用simpledateformat
 */
@Slf4j
public class SimpleDateFormartUse01 {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new SimpleDateFormartUse01().date(10);
                log.info(date);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new SimpleDateFormartUse01().date(10000);
                log.info(date);
            }
        }).start();

    }

    /**
     * 通过时间秒进行日期转换
     */
    public String date(int seconds) {
        Date date = new Date(seconds * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
