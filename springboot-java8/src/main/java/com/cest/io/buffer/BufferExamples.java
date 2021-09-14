package com.cest.io.buffer;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class BufferExamples {

    public static final String WORD = "word";

    public static void writeFile() throws IOException {
        Random random = new Random();
        FileOutputStream fout = new FileOutputStream(WORD);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            for (int i1 = 0; i1 < 5; i1++) {
                fout.write(97 + random.nextInt(5));
            }
        }
        fout.close();
        System.out.println((System.currentTimeMillis() - startTime));
    }

    public static void writeFile_withBuffer() throws IOException {
        Random random = new Random();
        int bufferSize = 4 * 1024;
        BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(WORD), bufferSize);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            for (int i1 = 0; i1 < 5; i1++) {
                fout.write(97 + random.nextInt(5));
            }
        }
        fout.close();
        System.out.println((System.currentTimeMillis() - startTime));
    }

    public static void readFile() throws IOException {
        FileInputStream fin = new FileInputStream(WORD);
        int b;
        long startTime = System.currentTimeMillis();
        while ((b = fin.read()) != -1) {

        }
        fin.close();
        System.out.println((System.currentTimeMillis() - startTime));
    }

    public static void readFile_withbuffer() throws IOException {
        BufferedInputStream fin = new BufferedInputStream(new FileInputStream(WORD));
        int b;
        long startTime = System.currentTimeMillis();
        while ((b = fin.read()) != -1) {

        }
        fin.close();
        System.out.println((System.currentTimeMillis() - startTime));
    }


    public static void readFile_NIO() throws IOException {
        FileChannel channel = new FileInputStream(WORD).getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(8 * 1024);
        long startTime = System.currentTimeMillis();
        while (channel.read(allocate) != -1) {
            //翻转
            allocate.flip();
            //读取数据
            allocate.clear();
        }
        System.out.println((System.currentTimeMillis() - startTime));

    }

    public static void main(String[] args) throws IOException {
//        writeFile();
//        writeFile_withBuffer();
//        readFile();
        readFile_withbuffer();
        readFile_NIO();
//        File file = new File("word");
//        if(file.exists()) {
//            file.delete();
//        }
    }
}
