package com.example.demo.netty.splitpackage;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

class NettyClient {
    public static void main(String args[]) throws Exception{
        EventLoopGroup group = new NioEventLoopGroup(1);

        Bootstrap bootstrap = new Bootstrap();

        try {
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast(new MessageEncoder())
                                    .addLast(new NettyClientHandler());
                        }
                    });
            ChannelFuture future = bootstrap.connect("127.0.0.1", 9000).sync();
//            Channel channel = future.channel();
//            for(int i = 0; i<100; i++) {
////                MessageWarp warp = new MessageWarp();
//                String msg = "你好，诸葛老师";
////                warp.setLength(msg.length());
////                warp.setContent(msg.getBytes());
////                channel.writeAndFlush(warp);
//                //创建协议包对象
//                MessageWarp messageProtocol = new MessageWarp();
//                messageProtocol.setLength(msg.getBytes(CharsetUtil.UTF_8).length);
//                messageProtocol.setContent(msg.getBytes(CharsetUtil.UTF_8));
//                channel.writeAndFlush(messageProtocol);
//            }
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
