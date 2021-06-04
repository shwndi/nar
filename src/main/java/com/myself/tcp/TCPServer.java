package com.myself.tcp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * @author czy
 * @date 2021/6/4
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //需要地址
        ServerSocket socket = new ServerSocket(9999);
        //等待客户端连接
        Socket accept = socket.accept();
        //读取消息
        InputStream is = accept.getInputStream();
        //管道流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int len;
        while ((len = is.read(buf)) != -1) {
            outputStream.write(buf,0,len);
        }
        System.out.println(outputStream.toString());
        //关闭连接
        outputStream.close();
        is.close();
        accept.close();
        socket.close();
    }
}
