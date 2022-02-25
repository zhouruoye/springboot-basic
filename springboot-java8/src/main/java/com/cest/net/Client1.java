package com.cest.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter out = null;
        try {
            socket = new Socket("127.0.0.1", 8080);
            out = new
                    PrintWriter(socket.getOutputStream(), true);
            out.println("Hello, Mic");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
