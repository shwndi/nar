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
public class TalkSend implements Runnable {
    DatagramSocket socket = null;
    BufferedReader reader = null;

    private int formPort;
    private int toPort;
    private String toIp;

    public TalkSend(int formPort, int toPort, String toIp) {
        this.formPort = formPort;
        this.toPort = toPort;
        this.toIp = toIp;

        try {
            socket = new DatagramSocket(formPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run() {
        while (true) {
            String date = null;
            try {
                date = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] datas = date.getBytes();
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.toIp, this.toPort));
            try {
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (date.equals("bye")) {
                break;
            }
        }
            socket.close();
    }
}
