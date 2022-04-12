package com.example.demo.netty.splitpackage;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MessageEncoder extends MessageToByteEncoder<MessageWarp> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageWarp messageWarp, ByteBuf byteBuf) throws Exception {
        int length = messageWarp.getLength();
        byteBuf.writeInt(length);
        byteBuf.writeBytes(messageWarp.getContent());
    }
}
