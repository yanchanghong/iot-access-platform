package com.iot.iotaccessplatform.interceptor;

import com.iot.iotaccessplatform.entity.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;


/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2020/8/13 10:19
 * @Version 1.0
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    public Object execute(HttpServletRequest request, BindException e, HttpServletResponse response) {
        e.printStackTrace();
        String errorMsg = e.getFieldErrors()
                .stream()
                .map(fieldError -> {
                    return String.format("%s%s", fieldError.getField(), fieldError.getDefaultMessage());
                })
                .collect(Collectors.joining("/"));
        return Response.error("000001", errorMsg);
    }


    @ExceptionHandler(Exception.class)
    public Object execute(HttpServletRequest request, Exception e, HttpServletResponse response) {
        e.printStackTrace();
        return Response.error("000001", e.getMessage());
    }
}
