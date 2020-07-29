package com.cest.filtermodel.listener;

import com.cest.filtermodel.evt.RainEvent;
import com.cest.filtermodel.evt.WeatherEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SnowListener implements WeatherListener {
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if(event instanceof RainEvent) {
            log.info("下雪啦:{}",event.getWeather());
        }
    }
}
