package com.iot.iotaccessplatform.server.netty.service;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2020/8/12 18:31
 * @Version 1.0
 **/
public class GBServer extends AbstractNettyServer {

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public ChannelInitializer<SocketChannel> getChannelInitializer() {
        return null;
    }
}
