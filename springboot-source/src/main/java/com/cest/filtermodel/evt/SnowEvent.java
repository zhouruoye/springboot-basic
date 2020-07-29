package com.cest.filtermodel.evt;

public class SnowEvent extends WeatherEvent {
    @Override
    public String getWeather() {
        return "下雪啦";
    }
}
