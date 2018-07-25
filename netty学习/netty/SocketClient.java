package com.netty;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @ Create by ostreamBaba on 18-7-25
 * @ 描述
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",8080);
        DataOutputStream output=new DataOutputStream(socket.getOutputStream());
        output.writeInt(4);
        output.writeBytes("sssssss\r\nssss");
        //第一个解码器只取 \r\n前面的内容
        output.flush();

        DataInputStream input=new DataInputStream(socket.getInputStream());
        int length=input.readInt();
        byte[] bytes=new byte[length];
        input.readFully(bytes,0,length);
        System.out.println(new String(bytes));

        socket.close();
    }

}
