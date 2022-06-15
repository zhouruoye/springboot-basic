package com.cest.dataStructures.hash;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 普通hash算法
 */
@Slf4j
public class GeneralHash {
    //定义客户端ip
    private static List<String> client = new ArrayList<>();
    //定义服务器数量
    private static final int serverCount = 4;

    static {
        client.add("192.168.0.1");
        client.add("192.168.0.2");
        client.add("192.168.2.3");
    }
    public static void main(String[] args) {
        for (String clientIP : client) {
            log.info("当前ip为：" + clientIP);
            int i = Math.abs(clientIP.hashCode())%serverCount;
            log.info("ip进入第{}台机器" ,i);
        }
    }
}
