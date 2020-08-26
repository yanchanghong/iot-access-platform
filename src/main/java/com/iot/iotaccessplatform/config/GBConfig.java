package com.iot.iotaccessplatform.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2020/8/13 17:36
 * @Version 1.0
 **/
@Configuration
@Data
public class GBConfig {
    @Value("${netty.port}")
    public Integer port;
    @Value("${netty.timeout}")
    public Integer timeout;
}
