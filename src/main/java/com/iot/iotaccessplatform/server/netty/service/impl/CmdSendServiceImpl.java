package com.iot.iotaccessplatform.server.netty.service.impl;

import com.iot.iotaccessplatform.server.netty.service.CmdSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2020/8/26 17:48
 * @Version 1.0
 **/
@Slf4j
@Service
public class CmdSendServiceImpl implements CmdSendService {

    @Override
    public void send(String message) {
        log.info("message:{}", message);
    }
}
