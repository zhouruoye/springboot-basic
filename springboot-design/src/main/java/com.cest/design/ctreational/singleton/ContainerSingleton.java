package com.cest.design.ctreational.singleton;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 容器单例模式 整个项目单例
 * Created by cestlavie on 2019/10/16.
 */
public class ContainerSingleton {
    private ContainerSingleton() {
    }

    private static Map<String,Object> singletonMap = new ConcurrentHashMap();

    public static void putInstance(String key,Object o){
        if(StringUtils.isNotBlank(key) && o != null){
            if(!singletonMap.containsKey(key)){
                singletonMap.put(key,o);
            }
        }
    }

    public static Object getInstance(String key){
        return singletonMap.get(key);
    }
}
