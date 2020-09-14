package com.cest.design.ctreational.factory;

/**
 * 工厂模式和简单工厂模式的区别主要是将工厂抽象化
 * 应用层不关心实例如何被创建，如何实现等细节
 * Created by cestlavie on 2019/10/16.
 */
public class FactoryTest {

    public static void main(String[] args) {
        VideoFactory java = new JavaVideoFactory();
        Video video = java.getVideo();
        video.transcribeVideo();
    }
}
