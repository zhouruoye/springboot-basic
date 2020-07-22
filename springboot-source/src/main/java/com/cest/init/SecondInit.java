package com.cest.init;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

@Order(10001)
public class SecondInit implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("我是初始化器2----start");
        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();

        //构建map数组
        Map<String, Object> map = new HashMap<>();
        map.put("key1","value1-2");
        map.put("key2","value2-2");

        //map配置源码
        MapPropertySource mapPropertySource = new MapPropertySource("secondInitializer", map);

        environment.getPropertySources().addLast(mapPropertySource);
        System.out.println("我是初始化器2----end");
    }
}
