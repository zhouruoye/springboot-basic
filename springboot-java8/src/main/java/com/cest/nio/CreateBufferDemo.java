package com.cest.nio;

import java.nio.ByteBuffer;

public class CreateBufferDemo {

    public static void main(String[] args) {
        //1.创建一个指定长度的缓冲区, 以ByteBuffer为例
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);

        int limit = byteBuffer.limit();
        for (int i = 0; i < 5; i++) {
            System.out.println(byteBuffer.get());
        }
        //在此调用会报错--后续再读缓冲区时着重讲解
        // System.out.println(byteBuffer.get());
        // 2.创建一个有内容的缓冲区
        ByteBuffer wrap = ByteBuffer.wrap("lagou".getBytes());
        for (int i = 0; i < 5; i++) {
            System.out.println(wrap.get());
        }

        //1.创建一个指定长度的缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(10);
        allocate.put("0123".getBytes());
        System.out.println("position:" + allocate.position());
        System.out.println("limit:" + allocate.limit());
        System.out.println("capacity:" + allocate.capacity());
        System.out.println("remaining:" + allocate.remaining());

        //切换读模式
        System.out.println("读取数据--------------");
        allocate.flip();
        System.out.println("position:" + allocate.position());//4
        System.out.println("limit:" + allocate.limit());//10
        System.out.println("capacity:" + allocate.capacity());
        System.out.println("remaining:" + allocate.remaining());
        for (int i = 0; i < allocate.limit(); i++) {
            System.out.println(allocate.get());
        }
    }
}
