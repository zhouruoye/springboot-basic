package com.cest.filtermodel.listener;

import com.cest.filtermodel.evt.WeatherEvent;

import org.springframework.stereotype.Component;


public interface WeatherListener {

    void onWeatherEvent(WeatherEvent event);
}
