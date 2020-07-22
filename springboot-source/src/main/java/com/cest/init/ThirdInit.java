package com.cest.init;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

@Order(10005)
public class ThirdInit implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("我是初始化器3----start");
        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();

        //构建map数组
        Map<String, Object> map = new HashMap<>();
        map.put("key1","value1-3");
        map.put("key3","value3-3");
        map.put("key4","value4-3");

        //map配置源码
        MapPropertySource mapPropertySource = new MapPropertySource("thirdInitializer", map);

        environment.getPropertySources().addLast(mapPropertySource);
        System.out.println("我是初始化器3----end");
    }
}
