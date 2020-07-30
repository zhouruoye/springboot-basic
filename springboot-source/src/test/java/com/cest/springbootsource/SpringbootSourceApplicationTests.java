package com.cest.springbootsource;

import com.cest.filtermodel.listener.WeatherRunListener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootSourceApplicationTests {

    @Autowired
    private WeatherRunListener weatherRunListener;

    @Test
    void contextLoads() {
    }

    @Test
    void testEvent(){
        weatherRunListener.rain();
        weatherRunListener.snow();
    }

}
