package com.cest.nullpointAndEx.try_with_resource;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static String generalCloseResource() throws Exception {
        String path = "D:\\tmp\\test.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        try {
//            一行一行的开始读取
            String line = null;
            while ((line=bufferedReader.readLine())!=null) {
                System.out.println(line);
            }
//            一个字符一个字符的读取
//            int result=0;
//            while((result=bufferedReader.read())!=-1)
//            {
//                //因为读取到的是int类型的，所以要强制类型转换
//                System.out.print((char)result);
//            }
        } finally {
            bufferedReader.close();
        }
        return path;
    }

    public static void main(String[] args) throws Exception{
        generalCloseResource();
    }
}
