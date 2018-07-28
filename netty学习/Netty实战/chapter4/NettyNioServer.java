package com.netty.NettyInAction.chapter4;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @ Create by ostreamBaba on 18-7-27
 * @ 描述
 */
public class NettyNioServer {

    public void server(int port) throws InterruptedException {
        final ByteBuf buf= Unpooled.unreleasableBuffer(
                Unpooled.copiedBuffer("Hi!\r\n",
                        Charset.forName("UTF-8"))
        );
        EventLoopGroup group=new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap=new ServerBootstrap(); //创建ServerBootstrap
            bootstrap.group(group)
                    .channel( NioServerSocketChannel.class) //使用NioEventLoopGroup不允许阻塞模式
                    .localAddress(new InetSocketAddress(port))
                    .childHandler( new ChannelInitializer<SocketChannel>() { //指定ChannelInitializer 对于每个已接受的连接都调用他
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast(new ChannelInboundHandlerAdapter(){ //拦截和处理事件
                                        @Override
                                        public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                            ctx.writeAndFlush(buf.duplicate())
                                                    .addListener( ChannelFutureListener.CLOSE);//将消息写入客户端
                                            // 并添加ChannelFutureListener以便消息一被写完就关闭连接
                                        }
                                    });
                        }
                    } );
            ChannelFuture future=bootstrap.bind().sync(); //绑定服务器以接受连接
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully().sync(); //释放所有的资源
        }
    }
}
