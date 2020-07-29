package com.cest.filtermodel.caster;

import com.cest.filtermodel.evt.WeatherEvent;
import com.cest.filtermodel.listener.WeatherListener;

public interface EventMulticaster {

    void multicastEvent(WeatherEvent event);

    void addListener(WeatherListener weatherListener);

    void removeListener(WeatherListener weatherListener);
}
