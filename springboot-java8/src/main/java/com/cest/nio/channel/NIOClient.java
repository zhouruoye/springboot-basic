package com.cest.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class NIOClient {

    public static void main(String[] args) throws IOException {
        //1 打开服务器通道
        SocketChannel open = SocketChannel.open();
        //2 建立连接
        open.connect(new InetSocketAddress("127.0.0.1",9000));
        //3.写出数据
        open.write(ByteBuffer.wrap("老板,该还钱拉!".getBytes(StandardCharsets.UTF_8)));
        //4.读取服务器写回的数据
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int read=open.read(readBuffer);
        System.out.println("服务端消息:" + new String(readBuffer.array(), 0, read, StandardCharsets.UTF_8));
        //5.释放资源
        open.close();

    }
}
