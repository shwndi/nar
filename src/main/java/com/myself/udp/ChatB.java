package com.myself.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 * @author czy
 * @date 2021/6/7
 */
public class ChatB {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);
        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);
            socket.receive(packet);
            byte[] data = packet.getData();
            String s = new String(data,0,packet.getLength());
            System.out.println(s);
            if (s.equals("bye")){
                break;
            }
        }
        socket.close();
    }
}
