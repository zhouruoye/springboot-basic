package com.cest.memory;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Test1 {

    private byte[] bytes = new byte[1024 * 1024];

    public static void main(String[] args) {
        List<Test1> list = new ArrayList<>();

        int num = 0;

        try {
            while (true) {
                list.add(new Test1());
                num ++;
            }
        } catch (Exception e) {
            log.info("system exception: {}", e);
        } catch (Throwable err) {
            err.printStackTrace();
            log.info("system error: {}", err);
            log.info("num is {}",num);
        }

        log.info("totalMemory:{}m", Runtime.getRuntime().totalMemory() / 1024.00 / 1024.00); //java虚拟机这个进程当时所占用的 所有 内存
        log.info("freeMemory:{}m", Runtime.getRuntime().freeMemory() / 1024.00 / 1024.00); //这些挖过来而又没有用上的内存
        log.info("maxMemory:{}m ", Runtime.getRuntime().maxMemory() / 1024.00 / 1024.00); // 默认机器内存的1/4
//      -Xms:设置初始分配大小，默认为物理内存的“1/64”   -Xms10m
//      -Xmx:最大分配内存，默认为物理内存的“1/4”   -Xmx10m
//      -Xmn:新生代大小，默认为整个堆的“3/8” 推荐25%-50%   -Xmn5m  G1收集器不推荐设置新生代大小
    }
}
