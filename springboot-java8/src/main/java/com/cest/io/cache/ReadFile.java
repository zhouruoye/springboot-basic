package com.cest.io.cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 读取文件夹内容并删除
 */
public class ReadFile {

    public ReadFile() {
    }

    public static void main(String[] args) throws IOException {
        readfile("E:\\file\\专栏\\极客");
    }

    /**
     * 读取某个文件夹下的所有文件
     */
    public static boolean readfile(String filepath) throws FileNotFoundException, IOException {
        try {

            File file = new File(filepath);
            if (!file.isDirectory()) {
                System.out.println("文件");
//                System.out.println("path=" + file.getPath());
//                System.out.println("absolutepath=" + file.getAbsolutePath());
                System.out.println("name1=" + file.getName());

            } else if (file.isDirectory()) {
                System.out.println("文件夹");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
//                        System.out.println("path=" + readfile.getPath());
//                        System.out.println("absolutepath="
//                                + readfile.getAbsolutePath());
                        String name = readfile.getName();

                        if(name.endsWith(".m4a")) {
                            System.out.println("name=" + readfile.getName());
                            //删除结尾为m4a的文件
                            readfile.delete();
                        } else if(name.endsWith(".mp3")) {
                            System.out.println("name=" + readfile.getName());
                            readfile.delete();
                        }

                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return true;
    }
}
