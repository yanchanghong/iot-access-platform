package com.iot.iotaccessplatform.server.netty.service;

import com.iot.iotaccessplatform.server.netty.IServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2020/8/12 18:01
 * @Version 1.0
 **/
@Slf4j
public abstract class AbstractNettyServer implements IServer {

    private EventLoopGroup bossGroup;

    private EventLoopGroup workerGroup;

    protected int port;

    protected int timeout;

    @Override
    public void start() {
        log.debug("开始启动服务端");
        bossGroup = new NioEventLoopGroup(1);
        workerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        // BACKLOG用于构造服务端套接字ServerSocket对象，标识当服务器请求处理线程全满时，用于临时存放已完成三次握手的请求的队列的最大长度。如果未设置或所设置的值小于1，Java将使用默认值50
        bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 100)
                .childHandler(getChannelInitializer());
        ChannelFuture future = bootstrap.bind(port);
        log.debug("绑定端口成功");
    }

    @Override
    public void stop() {
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }

    public abstract ChannelInitializer<SocketChannel> getChannelInitializer();

}
