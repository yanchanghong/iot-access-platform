package com.iot.iotaccessplatform;

import com.iot.iotaccessplatform.config.GBConfig;
import com.iot.iotaccessplatform.server.netty.service.GBServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class IotAccessPlatformApplication {

    @Autowired
    private GBConfig gbConfig;

    public static void main(String[] args) {
        SpringApplication.run(IotAccessPlatformApplication.class, args);
    }

    @Bean
    public GBServer server() {
        GBServer gbserver = new GBServer();
        gbserver.setPort(gbConfig.getPort());
        gbserver.setTimeout(gbConfig.getTimeout());
        return gbserver;
    }
}
