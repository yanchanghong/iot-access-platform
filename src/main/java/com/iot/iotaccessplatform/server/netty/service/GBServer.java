package com.iot.iotaccessplatform.server.netty.service;

import com.iot.iotaccessplatform.encode.PayloadEncoder;
import com.iot.iotaccessplatform.server.netty.service.impl.GBNettyDealMessageHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2020/8/12 18:31
 * @Version 1.0
 **/
public class GBServer extends AbstractNettyServer {

    @Autowired
    private GBNettyDealMessageHandler gbNettyDealMessageHandler;

    @PostConstruct
    @Override
    public void start() {
        super.start();
    }

    @PreDestroy
    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public ChannelInitializer<SocketChannel> getChannelInitializer() {
        return new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline pipeline = socketChannel.pipeline();
                pipeline.addLast(
                        new LengthFieldBasedFrameDecoder(1024, 22, 2, 1, 0),
                        new PayloadEncoder(),
                        new IdleStateHandler(0, 0, timeout),    gbNettyDealMessageHandler);
            }
        };
    }
}
