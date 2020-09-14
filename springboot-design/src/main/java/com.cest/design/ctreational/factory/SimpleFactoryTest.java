package com.cest.design.ctreational.factory;

/**
 * Created by cestlavie on 2019/10/16.
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        VideoFactory java = new JavaVideoFactory();
        Video video = java.getVideo();
        video.transcribeVideo();
    }
}
