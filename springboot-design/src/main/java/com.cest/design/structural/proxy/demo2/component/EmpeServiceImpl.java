package com.cest.design.structural.proxy.demo2.component;

import com.cest.design.structural.proxy.demo2.entity.Empe;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * Created by cestlavie on 2019/11/14.
 */
@Slf4j
public class EmpeServiceImpl implements EmpeService {
    @Override
    public int deleteEmpeById(String id) {
        log.info("开始执行删除员工方法");
        log.info("删除员工编号为{}的员工",id);
        return 1;
    }

    @Override
    public int addOneEmpe(Empe empe) {
        log.info("开始执行添加员工方法");
        return Optional.ofNullable(empe).isPresent() ? 1 : 0;
    }
}
