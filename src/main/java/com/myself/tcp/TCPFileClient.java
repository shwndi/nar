package com.myself.tcp;

import java.io.File;
import java.io.FileInputStream;
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
public class TCPFileClient {
    public static void main(String[] args) throws IOException {
        //知道服务器地址和端口号
        InetAddress address = InetAddress.getByName("localhost");
        int port =9999;
        //创建一个socket连接
        Socket socket = new Socket(address,port);
        //创建一个输出流，写入消息发送
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("头像2.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while((len= fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        //关闭连接
        fis.close();
        os.close();
        socket.close();
    }
}
