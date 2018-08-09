package com.andy.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 基本返回结果集
 * @author: lyon
 * @since: 2018-07-26
 **/
@Data
public class Result<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    private Result() {
    }

    private Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> build(int code, String message, T data) {
        return new Result<>(code, message, data);
    }

    public static <T> Result<T> build(ResultEnum resultEnum, T data) {
        return new Result<>(resultEnum.getCode(), resultEnum.getMessage(), data);
    }

    public static <T> Result<T> build(ResultEnum resultEnum) {
        return new Result<>(resultEnum.getCode(), resultEnum.getMessage(), null);
    }

    public static <T> Result<T> error(Integer code) {
        return new Result<>(code, "ERROR", null);
    }

    public static <T> Result<T> success(Integer code) {
        return new Result<>(code, "SUCCESS", null);
    }

}
