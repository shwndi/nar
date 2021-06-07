package com.myself.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author czy
 * @date 2021/6/4
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        //建立一个socket
        DatagramSocket socket = new DatagramSocket();
        //建立数据包
        String msg = "hello world!";
        //发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);
        socket.send(packet);
        socket.close();
    }
}
