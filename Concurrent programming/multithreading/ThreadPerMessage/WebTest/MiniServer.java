package com.multithreading.ThreadPerMessage.WebTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ Create by ostreamBaba on 18-6-13
 * @ √Ë ˆ
 */
public class MiniServer {
    private final int portNumber;

    public MiniServer(int portNumber) {
        this.portNumber = portNumber;
    }

    public void execute()throws IOException{
        ServerSocket serverSocket=new ServerSocket(portNumber);
        System.out.println("Listening on "+serverSocket);
        try{
            while (true){
                System.out.println("Accepting");
                Socket clientSocket=serverSocket.accept();
                System.out.println("connect to "+clientSocket);
                try{
                    Service.service(clientSocket);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            serverSocket.close();
        }
    }
}
