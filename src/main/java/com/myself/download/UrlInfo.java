package com.myself.download;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

/**
 * @author czy
 * @date 2021/6/7
 */
public class UrlInfo {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3859417927,1640776349&fm=11&gp=0.jpg");
        System.out.println(url.getAuthority());
        System.out.println(url.getProtocol());//协议
        System.out.println(url.getPort());//端口
        System.out.println("Host"+url.getHost());//主机ip
        System.out.println("File"+url.getFile());//qun
        System.out.println("Path"+url.getPath());//文件
        System.out.println("UserInfo"+url.getUserInfo());

    }
}
