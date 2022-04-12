package com.example.demo.netty.splitpackage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

class NettyServerHandler extends SimpleChannelInboundHandler<MessageWarp> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageWarp msg) throws Exception {
        System.out.println("====服务端接收到消息如下====");
        System.out.println("长度=" + msg.getLength());
        System.out.println("内容=" + new String(msg.getContent(), CharsetUtil.UTF_8));
//        System.out.println("服务端接收到消息包数量=" + (++this.count));
    }
}
