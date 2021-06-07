package com.myself.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * @author czy
 * @date 2021/6/4
 */
public class TCPFileServer {
    public static void main(String[] args) throws IOException {
        //需要地址
        ServerSocket socket = new ServerSocket(9999);
        //等待客户端连接
        Socket accept = socket.accept();
        //读取消息
        InputStream is = accept.getInputStream();

        FileOutputStream fos = new FileOutputStream(new File("get.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer,0,len);
        }
        //关闭连接
        fos.close();
        is.close();
        accept.close();
        socket.close();
    }
}
