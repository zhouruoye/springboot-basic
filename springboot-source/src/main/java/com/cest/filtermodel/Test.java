package com.cest.filtermodel;

import com.cest.filtermodel.caster.WeatherEventMulticaster;
import com.cest.filtermodel.evt.RainEvent;
import com.cest.filtermodel.evt.SnowEvent;
import com.cest.filtermodel.listener.RainListener;
import com.cest.filtermodel.listener.SnowListener;

public class Test {

    public static void main(String[] args) {
        //构造广播器
        WeatherEventMulticaster eventMulticaster = new WeatherEventMulticaster();
        RainListener rainListener = new RainListener();
        SnowListener snowListener = new SnowListener();
        eventMulticaster.addListener(rainListener);
        eventMulticaster.addListener(snowListener);
        eventMulticaster.multicastEvent(new SnowEvent());
        eventMulticaster.multicastEvent(new RainEvent());
        eventMulticaster.removeListener(rainListener);
        eventMulticaster.multicastEvent(new SnowEvent());
        eventMulticaster.multicastEvent(new RainEvent());
    }

}
