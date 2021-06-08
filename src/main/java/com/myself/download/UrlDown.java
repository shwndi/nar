package com.myself.download;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author czy
 * @date 2021/6/7
 */
public class UrlDown {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3859417927,1640776349&fm=11&gp=0.jpg");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream stream = connection.getInputStream();
        FileOutputStream outputStream = new FileOutputStream("aaa.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while ((len= stream.read(buffer))!=-1){
            outputStream.write(buffer,0,len);
        }
        System.out.println(outputStream);

    }
}
