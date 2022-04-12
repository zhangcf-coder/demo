package com.example.demo.netty.splitpackage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

class NettyClientHandler extends SimpleChannelInboundHandler<MessageWarp> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageWarp messageWarp) throws Exception {
        System.out.println(messageWarp.getContent());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String msg = "你好，诸葛老师";
        for(int i = 0; i< 100; i++) {
            // 创建协议包对象
            MessageWarp messageProtocol = new MessageWarp();
            messageProtocol.setLength(msg.getBytes(CharsetUtil.UTF_8).length);
            messageProtocol.setContent(msg.getBytes(CharsetUtil.UTF_8));
            ctx.writeAndFlush(messageProtocol);
        }
    }
}
