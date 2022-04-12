package com.example.demo.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

class NettyClient {

    public static void main(String args[]) throws Exception{
        EventLoopGroup group = new NioEventLoopGroup(1);

        Bootstrap bootstrap = new Bootstrap();

        try {
            bootstrap
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast("encoder", new StringEncoder())
                                    .addLast("decoder", new StringDecoder())
                                    .addLast(new NettyClientHandler());
                        }
                    });
            ChannelFuture sync = bootstrap.connect("127.0.0.1", 9000).sync();
            Channel channel = sync.channel();
            Scanner scanner = new Scanner(System.in);

//            while (scanner.hasNextLine()) {
//                String s = scanner.nextLine();
//                channel.writeAndFlush(s);
//            }
            for(int i = 0; i < 100; i++) {
                channel.writeAndFlush("hello, world!");
            }
        }finally {
            group.shutdownGracefully();
        }
    }
}
