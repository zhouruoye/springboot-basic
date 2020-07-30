package com.cest.filtermodel.listener;

import com.cest.filtermodel.caster.WeatherEventMulticaster;
import com.cest.filtermodel.evt.RainEvent;
import com.cest.filtermodel.evt.SnowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherRunListener {

    @Autowired
    private WeatherEventMulticaster eventMulticaster;

    public void snow() {
        eventMulticaster.multicastEvent(new SnowEvent());
    }

    public void rain() {
        eventMulticaster.multicastEvent(new RainEvent());
    }
}
