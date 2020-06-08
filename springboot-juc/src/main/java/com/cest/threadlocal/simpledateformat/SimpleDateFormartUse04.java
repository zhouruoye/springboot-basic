package com.cest.threadlocal.simpledateformat;

import com.cest.threadlocal.threadlocal.ThreadSimpledateformat;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * 版本4 使用threadlocal
 * 假如有N个线程 优化成线程池
 * 由于工具类SimpleDateFormat不是线程安全的 最后size数小于1000
 */
@Slf4j
public class SimpleDateFormartUse04 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        Vector<String> vector = new Vector<String>(1000);

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    String date = new SimpleDateFormartUse04().date(finalI);
                    vector.add(date);
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
        Map<String, List<String>> collect = vector.stream().collect(Collectors.groupingBy(n -> n));
        log.info("list的size为:{}",vector.size());
        log.info("map的size为:{}",collect.size());
    }




    public String date(int seconds) {
        Date date = new Date(seconds * 1000);
        return ThreadSimpledateformat.dateFormatThreadLocal2.get().format(date);
    }
}
