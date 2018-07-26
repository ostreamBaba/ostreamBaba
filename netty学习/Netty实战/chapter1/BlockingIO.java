package com.netty.NettyInAction.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ Create by ostreamBaba on 18-7-26
 * @ 阻塞 I/O
 */
public class BlockingIO {

    public void server(int portNumber) throws IOException {
        //int portNumber=8080;

        //创建一个ServerSocket 监听并绑定一个接口(链接请求)
        ServerSocket serverSocket=new ServerSocket(portNumber);
        //服务器使用Accept方法 获得一个来自客户端的Socket链接对象
        //对Accept方法的调用将被阻塞 直到下一个链接建立
        Socket clientSocket=serverSocket.accept();
        //这些流对象都派生于该套接字的流对象
        BufferedReader in=new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
        ); //从字符输入流中读取文本

        PrintWriter out=new PrintWriter(clientSocket.getOutputStream(),true);

        String request,response;
        while ((request=in.readLine())!=null){
            if("Done".equals(request)){
                break;
            }
            response=processRequest(request);  //请求传递给服务器的处理方法
            //服务器的响应被发送到客户端
            out.print(response);
        }
    }

    private String processRequest(String request) {
        return "process";
    }


}
