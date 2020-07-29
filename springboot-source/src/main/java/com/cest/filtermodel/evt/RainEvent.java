package com.cest.filtermodel.evt;

public class RainEvent extends WeatherEvent{
    @Override
    public String getWeather() {
        return "下雨啦";
    }
}
