package com.cest.threadlocal.simpledateformat;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * 版本3 加synchronized
 * 假如有N个线程 优化成线程池
 * 由于工具类SimpleDateFormat不是线程安全的 最后size数小于1000
 */
@Slf4j
public class SimpleDateFormartUse03 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static void main(String[] args) {
        Vector<String> dates = new Vector<String>(1000);
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    String date = new SimpleDateFormartUse03().dateNew(finalI);
                    dates.add(date);
                    log.info(date);
                }
            });
        }

        executorService.shutdown();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, List<String>> collect = dates.stream().collect(Collectors.groupingBy(n -> n));
        log.info("list的size为:{}",dates.size());
        log.info("map的size为:{}",collect.size());
    }

    /**
     * synchronized代码块 线程安全
     * 通过时间秒进行日期转换
     */
    public String date(int seconds) {
        Date date = new Date(seconds * 1000);
        String format = null;
        synchronized (SimpleDateFormartUse03.class) {
            format = simpleDateFormat.format(date);
        }
        return format;
    }


    /**
     * synchronized方法 对于simpleDateFormat线程不安全
     * 通过时间秒进行日期转换
     */
    public synchronized String dateNew(int seconds) {
        Date date = new Date(seconds * 1000);
        return simpleDateFormat.format(date);
    }
}
