package com.myself.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端
 *
 * @author czy
 * @date 2021/6/4
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //知道服务器地址和端口号
        InetAddress address = InetAddress.getByName("localhost");
        int port =9999;
        //创建一个socket连接
        Socket socket = new Socket(address,port);
        //创建一个输出流，写入消息发送
        OutputStream os = socket.getOutputStream();
        os.write("Welcome to here ".getBytes());
        //关闭连接
        os.close();
        socket.close();
    }
}
