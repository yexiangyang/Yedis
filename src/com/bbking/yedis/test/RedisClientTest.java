package com.bbking.yedis.test;

import java.io.*;
import java.net.Socket;

public class RedisClientTest {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.51.11", 6377);
            socket.setSoTimeout(5000);

            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            for (int i = 0; i < 1000; i++) {
                String first = "*3\r\n$3\r\nSET\r\n";
                String sedond = "$" + (String.valueOf(i).length() + 1) + "\r\na" + i + "\r\n";
                String thired = "$" + String.valueOf(i).length() + "\r\n" + i + "\r\n";
                String all = first + sedond + thired;
                bufferedWriter.write(all);
                bufferedWriter.flush();
            }
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int length = inputStream.read(bytes);
            String a = new String(bytes, 0, length);
            System.err.println(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
