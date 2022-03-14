package com.cest.service.proxy;

import com.cest.design.structural.proxy.demo2.entity.Empe;

/**
 * Created by cestlavie on 2019/11/14.
 */
public interface EmpeService {

    int deleteEmpeById(String id);

    int addOneEmpe(Empe empe);
}
