package com.cest.design.ctreational.simpleFactory;

import com.cest.status.SimpleFactoryType;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by cestlavie on 2019/10/16.
 */
public class VideoFactory {

    /**
     * 优化2 - 反射
     * 限制传参的范围 定义为当前对象的子类
     * @param c
     * @return
     */
    public Video getVideo(Class<? extends Video> c){
        if(c != null) {
            try {
                return c.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 优化1 - 反射
     * @param c
     * @return
     */
//    public Video getVideo(Class c){
//        Video video = null;
//        try {
//            video = (Video) Class.forName(c.getName()).newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return video;
//    }

    /**
     * 原始写法
     * 每次新增一个类型需要重新维护接口 不符合开闭原则 使用反射
     * @param type
     * @return
     */
    public Video getVideo(String type){
        if(StringUtils.isNotBlank(type)){
            if(SimpleFactoryType.JAVA.equals(type)){
                return new JavaVideo();
            }else if(SimpleFactoryType.PYTHON.equals(type)){
                return new PythonVideo();
            }
        }
        return null;
    }
}
