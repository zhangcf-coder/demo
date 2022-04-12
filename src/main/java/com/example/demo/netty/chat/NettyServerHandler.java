package com.example.demo.netty.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

class NettyServerHandler extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        String msg = "服务器接收到了客户端：" + channelHandlerContext.channel().remoteAddress() + "发送了信息：" + s;
        System.out.println(msg);
        channels.forEach(ch -> {
            if(ch == channelHandlerContext.channel()) {
                ch.writeAndFlush("[自己发送了信息]" + s);
            } else {
                ch.writeAndFlush(channelHandlerContext.channel().remoteAddress() + "发送了信息：" + s);
            }
        });
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String msg = ctx.channel().remoteAddress() + ",已上线";
        System.out.println(msg);
        channels.writeAndFlush(msg);
        channels.add(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("服务器接收到" + ctx.channel().remoteAddress() + "的下线通知！");
        ctx.writeAndFlush(ctx.channel().remoteAddress() + "已下线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}