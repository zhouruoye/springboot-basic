package com.cest.listener.listener1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PigFactory {
    @Bean(name = "tom")
    public Pig getPigTom(){
        return new Pig("tom", "i am tom");
    }

    @Bean(name = "sec")
    public Pig getPigSec(){
        return new Pig("Sec", "i am sec");
    }
}
