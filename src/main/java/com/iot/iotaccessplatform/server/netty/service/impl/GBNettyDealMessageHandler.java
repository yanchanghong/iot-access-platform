package com.iot.iotaccessplatform.server.netty.service.impl;

import com.iot.iotaccessplatform.server.netty.service.AbstractNettyGBHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2020/8/13 17:11
 * @Version 1.0
 **/
@Slf4j
@Component
public class GBNettyDealMessageHandler extends AbstractNettyGBHandler {

    public void dealGBMessage() {
        log.info("deal message");
    }
}
