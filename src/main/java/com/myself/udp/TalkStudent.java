package com.myself.udp;

/**
 * @author czy
 * @date 2021/6/7
 */
public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend(7777,9999,"localhost")).start();
        new Thread(new TalkReceive(8888,"Student")).start();
    }
}
