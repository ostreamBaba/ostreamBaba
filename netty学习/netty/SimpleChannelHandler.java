package com.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * @ Create by ostreamBaba on 18-7-25
 * @ 描述
 */
public class SimpleChannelHandler extends ChannelInboundHandlerAdapter{

    /**
     * @ 描述 读取客户端通道数据
     * @ param ctx
     * @ param msg
     * @ return void
     * @ create by ostreamBaba on 下午8:31 18-7-25
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof ByteBuf){
            System.out.println(((ByteBuf) msg).toString( Charset.defaultCharset()));
            ctx.channel().writeAndFlush("is ok");
        }
    }
}
