package com.cest.net;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class Server2 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        //创建一个serversocket在端口8080监听客户请求
        Socket socket = null;
        try {
            socket = server.accept();
        } catch (IOException e) {
            log.error("Exception Error",e);
        }

    }
}
