package com.cest.filtermodel.listener;

import com.cest.filtermodel.evt.SnowEvent;
import com.cest.filtermodel.evt.WeatherEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SnowListener implements WeatherListener {
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if(event instanceof SnowEvent) {
            log.info("下雪啦:{}",event.getWeather());
        }
    }
}
