package com.iot.iotaccessplatform.encode;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2020/8/26 16:53
 * @Version 1.0
 **/
@Slf4j
public class PayloadEncoder extends MessageToMessageEncoder {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, List list) throws Exception {
        log.info("en code");
    }
}
