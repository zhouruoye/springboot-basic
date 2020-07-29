package com.cest.filtermodel.caster;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WeatherEventMulticaster extends AbstractEventMulticaster {

    @Override
    void doStart() {
        log.info("开始方法");
    }

    @Override
    void doEnd() {
        log.info("结束方法");
    }
}
