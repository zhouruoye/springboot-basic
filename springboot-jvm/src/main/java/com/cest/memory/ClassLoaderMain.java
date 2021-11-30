package com.cest.memory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderMain {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        //这个类class的路径
        String classPath = "D:\\development\\workspace\\github\\mygithub\\springboot-basic\\springboot-jvm\\src\\main\\java\\com\\cest\\memory\\Log.class";

        MyClassLoader myClassLoader = new MyClassLoader(classPath);
        //类的全称
        String packageNamePath = "com.cest.memory.Log";

        //加载Log这个class文件
        Class<?> Log = myClassLoader.findClass(packageNamePath);

        System.out.println("类加载器是:" + Log.getClassLoader());

        //利用反射获取main方法
        Method method = Log.getDeclaredMethod("main", String[].class);
        Object object = Log.newInstance();
        String[] arg = {"ad"};
        method.invoke(object, (Object) arg);
    }

}
