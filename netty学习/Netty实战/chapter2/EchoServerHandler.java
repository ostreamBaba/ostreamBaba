package com.netty.NettyInAction.chapter2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;


/**
 * @ Create by ostreamBaba on 18-7-26
 * @ 实现业务逻辑服务
 */

@ChannelHandler.Sharable  //标记ChannelHandler可以被多个Channel安全地共享
public class EchoServerHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof ByteBuf){
            ByteBuf in=(ByteBuf) msg;
            //将消息记录在控制台
            System.out.println("Server received: "+in.toString(CharsetUtil.UTF_8));
            ctx.write(in); //将接受到的消息写给发送者 而不冲刷出站消息
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将未决消息冲刷到远程节点 并且关闭该Channel
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace(); //打印异常栈跟踪
        ctx.close(); //关闭该Channel
    }
}
