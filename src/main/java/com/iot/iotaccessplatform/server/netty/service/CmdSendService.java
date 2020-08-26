package com.iot.iotaccessplatform.server.netty.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2020/8/26 17:46
 * @Version 1.0
 **/

public interface CmdSendService {

    void send(String message);
}
