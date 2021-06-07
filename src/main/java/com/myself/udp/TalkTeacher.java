package com.myself.udp;

/**
 * @author czy
 * @date 2021/6/7
 */
public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSend(6666,8888,"localhost")).start();
        new Thread(new TalkReceive(9999,"Student")).start();
    }
}
