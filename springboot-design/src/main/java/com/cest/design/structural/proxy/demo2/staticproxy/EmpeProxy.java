package com.cest.design.structural.proxy.demo2.staticproxy;

import com.cest.design.structural.proxy.demo2.component.EmpeService;
import com.cest.design.structural.proxy.demo2.entity.Empe;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by cestlavie on 2019/11/14.
 */
@Slf4j
public class EmpeProxy implements EmpeService {

    private EmpeService empeService;

    public EmpeProxy(EmpeService empeService) {
        this.empeService = empeService;
    }

    @Override
    public int deleteEmpeById(String id) {
        doSomethingBeforeProxy(id);
        int i = empeService.deleteEmpeById(id);
        doSomethingAfterProxy(i);
        return i;
    }

    @Override
    public int addOneEmpe(Empe empe) {
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
