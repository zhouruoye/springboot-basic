package com.cest.service.proxy.impl;

import com.cest.design.structural.proxy.demo2.entity.Empe;
import com.cest.service.proxy.EmpeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by cestlavie on 2019/11/14.
 */
@Slf4j
@Service("empeProxy")
public class EmpeProxy implements EmpeService {

    @Qualifier("empeServiceImpl")
    @Autowired
    private EmpeService empeService;

    @Override
    public int deleteEmpeById(String id) {
        doSomethingBeforeProxy(id);
        int i = empeService.deleteEmpeById(id);
        doSomethingAfterProxy(i);
        return i;
    }

    @Override
    public int addOneEmpe(Empe empe) {
        log.info("添加员工代理模式");
        return 0;
    }

    private void doSomethingBeforeProxy(String id){
        log.info("在执行方法前调用,员工编号是{}",id);
    }

    private void doSomethingAfterProxy(int state){
        String msg = state == 1 ? "成功" : "失败";
        log.info("在执行方法后调用,删除状态是:删除{}",msg);
    }

}
