package com.netty.NettyInAction.chapter1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @ Create by ostreamBaba on 18-7-26
 * @ 回调实战
 */
public class ConnectExample {

    private static final Channel CHANNEL=new NioSocketChannel();

    public static void connect(){
        Channel channel=CHANNEL;
        final ChannelFuture future=channel.connect(
                new InetSocketAddress("192.168.0.1",25)
        ); //异步地连接到远程节点
        //Does no block
        //注册一个ChannelFutureListener 以便在操作完成时获得通知
        future.addListener( new ChannelFutureListener() {
            //检查操作状态
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if(channelFuture.isSuccess()){
                    //操作成功创建一个ByteBuf以持有数据
                    ByteBuf buffer= Unpooled.copiedBuffer("hello", Charset.defaultCharset());
                    //将数据异步地发送到远程的节点
                    ChannelFuture wf=channelFuture.channel().writeAndFlush(buffer);
                }else{
                    Throwable cause=channelFuture.cause(); //发送错误则访问描述原因的Throwable
                    cause.printStackTrace();
                }
            }
        } );
    }
}
