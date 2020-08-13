package com.iot.iotaccessplatform.server.netty;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2020/8/12 17:47
 * @Version 1.0
 **/
public interface IServer {

    /**
     * 启动监听端口
     */
    void start();

    /**
     * 关闭端口监听
     */
    void stop();
}
