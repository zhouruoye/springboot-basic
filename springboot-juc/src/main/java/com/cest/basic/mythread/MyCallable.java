package com.cest.basic.mythread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Callable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyCallable implements Callable {

    private String name;

    @Override
    public Object call() throws Exception {
        return name;
    }
}
