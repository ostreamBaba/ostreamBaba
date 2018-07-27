package com.netty.NettyInAction.chapter2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @ Create by ostreamBaba on 18-7-26
 * @ 描述
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception{
        if(args.length!=1){
            System.err.println("Usage: "+EchoServer.class.getSimpleName()+" <port>");
        }
        int port=Integer.parseInt(args[0]);
        new EchoServer(port).start(); //调用服务器的start方法
    }

    public void start() throws InterruptedException {
        final EchoServerHandler serverHandler=new EchoServerHandler();
        EventLoopGroup group=new NioEventLoopGroup();
        try{
            ServerBootstrap bootstrap=new ServerBootstrap();
            bootstrap.group(group)
                    .channel(NioServerSocketChannel.class) //指定所使用的NIO传输Channel
                    .localAddress(new InetSocketAddress(port))//使用指定的端口设置套接字地址
                    .childHandler( new ChannelInitializer<SocketChannel>() {//添加一个EchoServerHandler到子Channel的ChannelPipeline
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(serverHandler);//EchoServerHandler被标记为@Shareable
                            // 所以我们可以总是使用同样的实例
                            //对所有的客户端连接来说 都会使用同一个EchoServerHandler(因为其被标注为@Sh   areable)
                        }
                    });
            ChannelFuture future=bootstrap.bind().sync();//异步地绑定服务器 调用sync()方法阻塞等待直到绑定完成
            future.channel().closeFuture().sync(); //获取Channel的CloseFuture 并且阻塞当前线程直到它完成

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully().sync(); //释放所有资源
        }
    }
}
