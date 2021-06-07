package com.myself.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author czy
 * @date 2021/6/7
 */
public class TalkReceive implements Runnable{
    DatagramSocket socket = null;
    private int port;
    private String msgFrom;

    public TalkReceive(int port, String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] data = packet.getData();
            String s = new String(data,0,packet.getLength());
            System.out.println(msgFrom+": "+s);
            if (s.equals("bye")){
                break;
            }
        }
        socket.close();
    }
}
