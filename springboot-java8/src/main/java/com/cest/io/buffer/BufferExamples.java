package com.cest.io.buffer;

import java.io.*;
import java.util.Random;

public class BufferExamples {

    public static void gen() throws IOException {
        Random random = new Random();
        String fileName = "word";

        FileOutputStream fout = new FileOutputStream(fileName);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            for (int i1 = 0; i1 < 5; i1++) {
                fout.write(97 + random.nextInt(5));
            }
        }
        fout.close();
        System.out.println((System.currentTimeMillis() - startTime));
    }

    public static void gen1() throws IOException {
        Random random = new Random();
        String fileName = "word";

        int bufferSize = 4 * 1024;
        BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(fileName),bufferSize);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            for (int i1 = 0; i1 < 5; i1++) {
                fout.write(97 + random.nextInt(5));
            }
        }
        fout.close();
        System.out.println((System.currentTimeMillis() - startTime));
    }

    public static void main(String[] args) throws IOException {
//        gen();
        gen1();

//        File file = new File("word");
//        if(file.exists()) {
//            file.delete();
//        }
    }
}
