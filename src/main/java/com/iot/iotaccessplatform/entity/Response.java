package com.iot.iotaccessplatform.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2020/8/13 10:51
 * @Version 1.0
 **/
@ApiModel(description = "统一返回结构体")
@Data
public class Response<T> implements Serializable {
    private static final long serialVersionUID = -6602365878131231511L;
    public static final String CODE_SUCCESS = "000000";
    public static final String MSG_SUCCESS = "SUCCESS";

    @ApiModelProperty(value = "业务码", name = "code", dataType = "String")
    private String code = "000000";

    @ApiModelProperty(value = "返回信息", name = "msg", dataType = "String")
    private String description = "SUCCESS";

    private T data;

    public Response() {
    }

    public Response(T data) {
        this.data = data;
    }

    public static <T> Response<T> success(T data) {
        return result(data, "000000", "SUCCESS");
    }

    public static <T> Response<T> result(T data, String code, String msg) {
        Response<T> response = new Response();
        response.setCode(code);
        response.setData(data);
        response.setDescription(msg);
        return response;
    }

    public static Response error(String errorCode, String extMessage) {
        Response response = new Response((Object) null);
        response.code = errorCode;
        if (extMessage != null) {
            response.description = extMessage;
        }
        return response;
    }

    public static Response success() {
        return success((Object) null);
    }
}
