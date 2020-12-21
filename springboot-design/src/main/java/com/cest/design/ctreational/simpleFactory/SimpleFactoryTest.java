package com.cest.design.ctreational.simpleFactory;

/**
 * 简单工程模式
 * Created by cestlavie on 2019/10/16.
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        VideoFactory videoFactory = new VideoFactory();
        //
        //Video video = videoFactory.getVideo(SimpleFactoryType.JAVA);
        //video.transcribeVideo();

        Video video = videoFactory.getVideo(JavaVideo.class);
        if(video == null){
            return;
        }
        video.transcribeVideo();
    }
}
