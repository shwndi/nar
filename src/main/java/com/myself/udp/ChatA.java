package com.myself.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author czy
 * @date 2021/6/7
 */
public class ChatA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        //准备数据：控制台输入
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String date = reader.readLine();
            byte[] datas = date.getBytes();
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));
            socket.send(packet);
            if (date.equals("bye")){
                break;
            }
        }
        socket.close();
    }
}
