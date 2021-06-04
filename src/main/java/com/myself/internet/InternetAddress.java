package com.myself.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/**
 * ip地址
 *
 * @author czy
 * @date 2021/6/3
 */
public class InternetAddress {
    public static void main(String[] args) {
        try {

            //获取本机ipv4和ipv6
            InetAddress[] all = InetAddress.getAllByName("localhost");
            List<InetAddress> list = Arrays.asList(all);
            System.out.println(list);
            InetAddress localhost1 = InetAddress.getByName("localhost");
            InetAddress localhost2 = InetAddress.getByName("127.0.0.1");
            System.out.println(localhost1);
            System.out.println(localhost2);
            InetAddress localhost3 = InetAddress.getLocalHost();
            System.out.println(localhost3);
            System.out.println("--------------------------------------------");

            //查询ip地址
            InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");
            System.out.println(Arrays.asList(allByName));

            InetAddress bd = InetAddress.getByName("www.baidu.com");
            System.out.println(bd);

            System.out.println(bd.getCanonicalHostName());//规范的名字
            System.out.println(bd.getHostAddress());//ip
            System.out.println(bd.getHostName());//域名
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
