package com.iot.iotaccessplatform.controller;

import com.iot.iotaccessplatform.entity.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2020/8/13 11:12
 * @Version 1.0
 **/
@RestController
@Api(tags = "命令下发控制")
@RequestMapping("/vi/cmd")
public class CmdController {

    @GetMapping("/send/cmd")
    @ApiOperation("发送指令")
    public Response sendCmd() throws Exception {
        throw new Exception("出错");
        //return Response.success();
    }
}
