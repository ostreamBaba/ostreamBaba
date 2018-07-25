package com.netty;

import com.multithreading.WorkerThread.Channel;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @ Create by ostreamBaba on 18-7-25
 * @ 描述
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        ServerBootstrap server=new ServerBootstrap();

        EventLoopGroup parentGroup=new NioEventLoopGroup();
        final EventLoopGroup childGroup=new NioEventLoopGroup();
        server.group(parentGroup,childGroup);
        server.channel( NioServerSocketChannel.class);
        server.childHandler( new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                //socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
                //等同于上面的代码 解码器 分隔符 /r /n 分隔符解码器
                //socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Unpooled.wrappedBuffer(new byte[]{13, 10})));
                //长度解码器
                socketChannel.pipeline().addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4
                        ,0,4));
                socketChannel.pipeline().addLast( new SimpleChannelHandler());
                //编码器
                //TailContext
                socketChannel.pipeline().addLast(new LengthFieldPrepender(4,false));
                socketChannel.pipeline().addLast(new StringEncoder());
            }
        } );
        ChannelFuture channelFuture=server.bind(8080).sync();
        channelFuture.channel().closeFuture().sync();

    }

}
