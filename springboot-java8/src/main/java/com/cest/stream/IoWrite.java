package com.cest.stream;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class IoWrite {

    public static void main(String[] args) throws IOException {
//        // 使用文件名称创建流对象
//        FileOutputStream fos = new FileOutputStream("springboot-java8/fos1.txt",true);
//        // 写出数据
//        fos.write(97); // 写出第1个字节
//        fos.write(98); // 写出第2个字节
//        fos.write(99); // 写出第3个字节
//        // 关闭资源
//        fos.close();

        // 使用文件名称创建流对象
        FileInputStream fis = new FileInputStream("springboot-java8/fos1.txt");//read.txt文件中内容为abcde
//        // 读取数据，返回一个字节
//        int b;
//        while ((b = fis.read()) != -1) {
//            System.out.println((char)b);
//        }
//
//        // 关闭资源
//        fis.close();


        byte[] bytes = new byte[1024];
        int len;
        while ((len=fis.read(bytes))!=-1){
            System.out.print(new String(bytes,0,len));
        }
        // 关闭资源
        fis.close();


        // 使用文件名称创建流对象
        FileReader fr = new FileReader("springboot-java8/fos1.txt");
        // 定义变量，保存数据
        int c;
        // 循环读取
        while ((c = fr.read())!=-1) {
            System.out.println((char)c);
        }
        // 关闭资源
        fr.close();

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("b.txt"));


    }
}
