package com.cest.threadlocal.simpledateformat;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * 版本2
 * 假如有N个线程 优化成线程池
 * 由于工具类SimpleDateFormat不是线程安全的 最后size数小于1000
 */
@Slf4j
public class SimpleDateFormartUse02 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        List<String> dates = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    String date = new SimpleDateFormartUse02().date(finalI);
                    dates.add(date);
                    log.info(date);
                }
            });
        }

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
     * 通过时间秒进行日期转换
     */
    public String date(int seconds) {
        Date date = new Date(seconds * 1000);
        return simpleDateFormat.format(date);
    }
}
