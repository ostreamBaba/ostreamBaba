package com.netty.NettyInAction.chapter1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @ Create by ostreamBaba on 18-7-26
 * @ Netty内部使用回调来处理事件 当一个回调被触发时 相关的事件可以被一个interface-ChannelHandler的实现处理
 */
public class ConnectHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //当一个新的连接已经被建立时，该方法会被调用
        System.out.println("Client "+ctx.channel().remoteAddress()+" connect");
    }
}
