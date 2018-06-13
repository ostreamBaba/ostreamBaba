package com.multithreading.ThreadPerMessage.WebTest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @ Create by ostreamBaba on 18-6-13
 * @ √Ë ˆ
 */
public class Service {
    private Service(){}

    public static void service(final Socket clientSocket)throws IOException{
        new Thread(){
            @Override
            public void run() {
                try {
                    doService(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /*http://127.0.0.1:8888/*/
    private static void doService(Socket clientSocket)throws IOException{
        System.out.println(Thread.currentThread().getName()+": Service.service("+clientSocket+") BEING");
        try{
            DataOutputStream out=new DataOutputStream(clientSocket.getOutputStream());
            out.writeBytes("HTTP/1.0 200 OK\r\n");
            out.writeBytes("Content-type: text/html\r\n");
            out.writeBytes("\r\n");
            out.writeBytes("<html><head><title>Countdown</title></head><body>");
            out.writeBytes("<h1>Countdown start");
            for (int i = 10; i > 0; --i) {
                System.out.println(Thread.currentThread().getName()+": Countdown i="+i);
                out.writeBytes("<p>"+i+"</p>");
                out.flush();
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            out.writeBytes("</body></html>");

        }finally {
            clientSocket.close();
        }
        System.out.println(Thread.currentThread().getName()+": Service.service("+clientSocket+") END");
    }
}
