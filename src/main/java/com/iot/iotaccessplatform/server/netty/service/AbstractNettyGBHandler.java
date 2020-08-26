package com.iot.iotaccessplatform.server.netty.service;

import com.iot.iotaccessplatform.utill.ByteUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2020/8/13 14:10
 * @Version 1.0
 **/
@Slf4j
@ChannelHandler.Sharable
public abstract class AbstractNettyGBHandler extends ChannelInboundHandlerAdapter {

    public AbstractNettyGBHandler() {
        super();
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("start receive message");
        if (msg instanceof ByteBuf && ((ByteBuf) msg).isReadable()) {
            ByteBuf byteBuf = (ByteBuf) msg;
            if (byteBuf.readableBytes() <= 0) {
                return;
            }
            ByteBuffer byteBuffer = byteBuf.nioBuffer();
            byte[] sourceBytes = new byte[byteBuffer.remaining()];
            byteBuffer.get(sourceBytes);
            byteBuffer.flip();
            log.info("receive sourceByte: " + ByteUtil.bytesToHexString(sourceBytes));

        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

}
