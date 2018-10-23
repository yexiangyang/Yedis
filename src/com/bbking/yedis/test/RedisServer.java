package com.bbking.yedis.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class RedisServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.err.println("服务器启动!");
            while (true) {
                System.err.println("时刻准备接收客户端!");
                Socket socket = serverSocket.accept();
                System.err.println("接收到客户端连接:ip【" + socket.getInetAddress().getHostName() + "】,port【" + socket.getPort() + "】");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            InputStream inputStream = socket.getInputStream();
                            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                            OutputStream outputStream = socket.getOutputStream();
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                            String msg = "";
                            while ((msg = bufferedReader.readLine()) != null) {
                                System.err.println("接收客户端" + socket.getPort() + "消息:" + msg);
                                bufferedWriter.write(msg + "\r\n");
                                bufferedWriter.flush();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
             /*   byte[] a = new byte[1024];
                int leng = 0;
                while ((leng = inputStream.read(a)) != -1) {
                    String msg = new String(a, 0, leng);
                    System.err.println("接收客户端消息:" + msg);
                }*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
