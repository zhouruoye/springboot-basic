package com.cest.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class TestService implements ApplicationContextAware {

    private ApplicationContext applicationContext1;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext1 = applicationContext;
    }

    public String test() {
        Environment environment = applicationContext1.getEnvironment();
        String key1 = environment.getProperty("key4");
        return key1;
    }
}
