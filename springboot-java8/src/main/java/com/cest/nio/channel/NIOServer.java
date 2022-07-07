package com.cest.nio.channel;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

@Slf4j
public class NIOServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        //1 打开服务器通道
        ServerSocketChannel open = ServerSocketChannel.open();
        //2 绑定端口
        open.bind(new InetSocketAddress(9000));
        //3. 通道默认是阻塞的，需要设置为非阻塞 true 为通道阻塞 false 为非阻塞
        open.configureBlocking(false);
        System.out.println("服务端开始启动");
        while (true) {
            //4 检查和客户端是否建立了连接
            SocketChannel accept = open.accept();
            if(accept == null) {
                //表示还没有建立连接
                System.out.println("----------------------表示还没有建立连接-----------------");
                Thread.sleep(1000);
                continue;
            }
            log.info("------------------已经建立了连接-------------------");
            //5. 获取客户端传递过来的数据,并把数据放在byteBuffer这个缓冲区中
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //返回值:
            // 正数: 表示本次读到的有效字节个数.
            // 0 : 表示本次没有读到有效字节.
            // -1 : 表示读到了末尾
            int read = accept.read(byteBuffer);
            System.out.println("客户端消息:" + new String(byteBuffer.array(), 0, read, StandardCharsets.UTF_8));
            //6. 给客户端回写数据
            accept.write(ByteBuffer.wrap("没 钱".getBytes(StandardCharsets.UTF_8)));
            //7. 释放资源
            accept.close();
        }
    }
}
