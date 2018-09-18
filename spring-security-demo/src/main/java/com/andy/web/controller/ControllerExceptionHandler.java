package com.andy.web.controller;

import com.andy.common.Result;
import com.andy.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author lyon
 * @since 2017-11-5 2:14:58
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
