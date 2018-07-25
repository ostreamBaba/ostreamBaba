package com.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @ Create by ostreamBaba on 18-7-25
 * @ √Ë ˆ
 */
public class NettyThread extends Thread{
    @Override
    public void run() {
        doStart();
    }

    private void doStart() {
        try {
            ServerBootstrap server=new ServerBootstrap();

            EventLoopGroup parentGroup=new NioEventLoopGroup();
            final EventLoopGroup childGroup=new NioEventLoopGroup();
            server.group(parentGroup,childGroup);
            server.channel( NioServerSocketChannel.class);
            server.childHandler( new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4
                            ,0,4));
                    socketChannel.pipeline().addLast( new SimpleChannelHandler());
                    socketChannel.pipeline().addLast(new LengthFieldPrepender(4,false));
                    socketChannel.pipeline().addLast(new StringEncoder());
                    System.out.println("---");
                }
            } );
            ChannelFuture channelFuture=server.bind(8080).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
