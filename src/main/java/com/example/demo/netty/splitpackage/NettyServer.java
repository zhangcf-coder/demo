package com.example.demo.netty.splitpackage;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

class NettyServer {

    public static void main(String args[]) throws Exception{
        EventLoopGroup group = new NioEventLoopGroup(1);

        EventLoopGroup work = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            bootstrap.group(group, work)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast(new MessageDecoder())
                                    .addLast(new NettyServerHandler());
                        }
                    });
            ChannelFuture sync = bootstrap.bind(9000).sync();
            sync.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
            work.shutdownGracefully();
        }
    }
}
