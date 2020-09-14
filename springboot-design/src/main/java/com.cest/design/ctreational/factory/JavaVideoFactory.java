package com.cest.design.ctreational.factory;

/**
 * Created by cestlavie on 2019/10/16.
 */
public class JavaVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
