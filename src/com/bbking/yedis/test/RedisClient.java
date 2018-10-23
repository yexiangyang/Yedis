package com.bbking.yedis.test;

import java.io.*;
import java.net.Socket;

public class RedisClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            socket.setSoTimeout(5000);
            InputStream inputStreamS = socket.getInputStream();
            InputStreamReader inputStreamReaderS = new InputStreamReader(inputStreamS);
            BufferedReader bufferedReaderS = new BufferedReader(inputStreamReaderS);

            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            InputStream inputStream = System.in;
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String msg = null;
            while ((msg = bufferedReader.readLine()) != null) {
                System.err.println("控制台输入信息:" + msg + ",将此信息发送到服务器");
                bufferedWriter.write(msg + "\r\n");
                bufferedWriter.flush();

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String S = bufferedReaderS.readLine();
                            System.err.println("接收服务器消息:" + S);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
