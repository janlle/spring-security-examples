package com.andy.demo.web.controller;

import com.andy.demo.common.Result;
import com.andy.demo.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <p> 全局异常处理器
 *
 * @author Leone
 * @since 2017-11-05
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotExistException.class)
    public Result<String> userNotExistException(UserNotExistException e) {
        return Result.build(40000, e.getMessage(), e.getId());
    }


}
