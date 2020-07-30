package com.cest.filtermodel.listener;

import com.cest.filtermodel.evt.RainEvent;
import com.cest.filtermodel.evt.WeatherEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RainListener implements WeatherListener{

    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if(event instanceof RainEvent) {
            log.info("下雨天:{}",event.getWeather());
        }
    }
}
