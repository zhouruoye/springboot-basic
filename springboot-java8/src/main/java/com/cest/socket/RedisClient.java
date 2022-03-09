package com.cest.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RedisClient {

    private Socket socket;
    private OutputStream write;
    private InputStream read;

    public RedisClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
        write = socket.getOutputStream();
        read = socket.getInputStream();
    }

    /**
     * 密码验证 *2$5\r\nauth\r\n$5\r\n12345
     * @param password
     * @throws IOException
     */
    public void auth(String password) throws IOException {
        StringBuffer sb = new StringBuffer();
        //*2：表示有两个字符串
        sb.append("*2").append("\r\n");
        //$4：表示auth长度为4
        sb.append("$4").append("\r\n");
        sb.append("auth").append("\r\n");
        sb.append("$").append(password.getBytes().length).append("\r\n");
        sb.append(password).append("\r\n");

        //发送命令
        write.write(sb.toString().getBytes());
        byte[] bytes = new byte[1024];
        //接收响应
        read.read(bytes);
        System.out.println("开始授权" + new String(bytes));
    }

    /**
     * 实现了set方法  *3\r\n$3\r\nSET\r\n$8\r\nqingshan\r\n$4\r\n2673\r\n
     * @param key
     * @param val
     * @throws IOException
     */
    public void set(String key, String val) throws IOException {
        StringBuffer sb = new StringBuffer();
        //代表3个参数
        sb.append("*3").append("\r\n");
        //第一个参数(set)的长度
        sb.append("$3").append("\r\n");
        //第一个参数的内容
        sb.append("SET").append("\r\n");
        //第二个参数key的长度(不定，动态获取)
        sb.append("$").append(key.getBytes().length).append("\r\n");
        //第二个参数key的内容
        sb.append(key).append("\r\n");
        //第三个参数value的长度(不定，动态获取)
        sb.append("$").append(val.getBytes().length).append("\r\n");
        //第三个参数value的内容
        sb.append(val).append("\r\n");
        //发送命令
        write.write(sb.toString().getBytes());
        byte[] bytes = new byte[1024];
        //接收响应
        read.read(bytes);
        System.out.println(new String(bytes));
    }

    /**
     * 实现了 get方法  *2\r\n$3\r\nGET\r\n$8\r\nqingshan\r\n
     * @param key
     * @throws IOException
     */
    public void get(String key) throws IOException {
        StringBuffer sb = new StringBuffer();
        //代表2个参数
        sb.append("*2").append("\r\n");
        //第一个参数(get)的长度
        sb.append("$3").append("\r\n");
        //第一个参数的内容
        sb.append("GET").append("r\n");
        //第二个参数key的长度
        sb.append("$").append(key.getBytes().length).append("\r\n");
        //第二个参数内容
        sb.append(key).append("\r\n");
        write.write(sb.toString().getBytes());
        byte[] bytes = new byte[1024];
        read.read(bytes);
        System.out.println(new String(bytes));
    }

    public static void main(String[] args) throws IOException {
        RedisClient client = new RedisClient("101.43.117.170", 6379);
        client.auth("mypassword");
        client.set("qingshan", "2673");
        client.get("qingshan");
    }
}
