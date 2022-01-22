package com.example.demo.netty.base;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

    public static void main(String args[]) throws Exception{
        EventLoopGroup
                nioEventLoopGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();

        try {
            bootstrap.group(nioEventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline().addLast(new NettyClientHandler());
                        }
                    });
            System.out.println("netty client start");
            // 启动客户端去连接服务端
            ChannelFuture fc = bootstrap.connect("127.0.0.1", 9000).sync();

            fc.channel().closeFuture().sync();
        }finally {
            nioEventLoopGroup.shutdownGracefully();
        }
    }
}
