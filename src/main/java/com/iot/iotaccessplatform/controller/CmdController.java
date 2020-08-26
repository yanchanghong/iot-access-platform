package com.iot.iotaccessplatform.controller;

import com.iot.iotaccessplatform.entity.Response;
import com.iot.iotaccessplatform.server.netty.service.CmdSendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2020/8/13 11:12
 * @Version 1.0
 **/
@RestController
@Api(tags = "命令下发控制")
@RequestMapping("/vi")
@Slf4j
public class CmdController {
    @Autowired
    private CmdSendService cmdSendService;

    @PostMapping("/send/cmd")
    @ApiOperation("发送指令")
    public Response sendCmd(@RequestBody String cmd) throws Exception {
        cmdSendService.send(cmd);
        return Response.success();
    }
}
