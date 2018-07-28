package com.netty.NettyInAction.chapter4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @ Create by ostreamBaba on 18-7-27
 * @ OIO
 */
public class PlainOioServer {


    public void serve(int port) throws IOException {
        ServerSocket socket=new ServerSocket(port); //将服务器绑定到指定端口
        try{
            for (;;){
                final Socket clientSocket=socket.accept(); //接受连接
                System.out.println(
                        "Accepted connection form "+clientSocket
                );
                new Thread(new Runnable() { //创建一个线程来处理该连接
                    @Override
                    public void run() {
                        OutputStream out;
                        try{
                            out=clientSocket.getOutputStream();
                            out.write("Hi!1\r\n".getBytes(  //将消息写给已连接的客户端
                                    Charset.forName("UTF-8")
                            ));
                            out.flush();
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            try {
                                clientSocket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } ).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
