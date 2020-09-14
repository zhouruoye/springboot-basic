package com.cest.design.ctreational.simpleFactory;

import com.cest.status.SimpleFactoryType;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by cestlavie on 2019/10/16.
 */
public class VideoFactory {

    //反射
    public Video getVideo(Class c){
        Video video = null;
        try {
            video = (Video) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return video;
    }

    /**
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
