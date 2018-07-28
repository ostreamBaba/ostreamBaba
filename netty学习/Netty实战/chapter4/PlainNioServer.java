package com.netty.NettyInAction.chapter4;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @ Create by ostreamBaba on 18-7-27
 * @ NIO
 */
public class PlainNioServer {

    public void server(int port) throws IOException {
        ServerSocketChannel serverChannel=ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        ServerSocket serverSocket=serverChannel.socket();
        InetSocketAddress address=new InetSocketAddress(port);
        serverSocket.bind(address);//将服务器绑定到端口
        Selector selector=Selector.open();//打开Selector来处理Channel
        serverChannel.register(selector, SelectionKey.OP_ACCEPT); //将ServerChannel注册到Selector以接受连接
        ByteBuffer msg=ByteBuffer.wrap("Hi!\r\n".getBytes());
        for(;;){
            try{
                selector.select(); //等待需要处理的新事件； 阻塞将持续到下一个传入事件
            }catch (IOException e){
                e.printStackTrace();
                break;
            }
            Set<SelectionKey> readyKeys=selector.selectedKeys();//获取所有接受事件的SelectionKey实例
            Iterator<SelectionKey> it=readyKeys.iterator();
            while (it.hasNext()){
                SelectionKey key=it.next();
                it.remove();
                try{
                    if(key.isAcceptable()){ //检查事件是否是一个新的已经就绪可以被接受的连接
                        ServerSocketChannel server=(ServerSocketChannel) key.channel();
                        SocketChannel client=server.accept();
                        client.configureBlocking(false);
                        client.register(selector,SelectionKey.OP_WRITE|SelectionKey.OP_READ,
                                msg.duplicate()); //接受客户端 并将他注册到选择器
                        System.out.println("Accepted connection form "+client);
                    }
                    if(key.isWritable()){ //检查套接字是否已经准备好写数据
                        SocketChannel client=(SocketChannel)key.channel();
                        ByteBuffer buffer= (ByteBuffer) key.attachment();
                        while (buffer.hasRemaining()){
                            if(client.write(buffer)==0){ //将数据写到已经连接的客户端
                                break;
                            }
                        }
                        client.close();
                    }
                }catch (IOException e){
                    key.cancel();
                    try {
                        key.channel().close();
                    }catch (IOException ex){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
