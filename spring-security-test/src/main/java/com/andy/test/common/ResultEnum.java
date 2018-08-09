package com.andy.test.common;

/**
 * @author: Mr.ruoLin
 * @since: 2018-01-03
 **/
public enum ResultEnum {

    SUCCESS(20000, "success"),
    ERROR(50000, "error"),
    USER_NOT_FOUND(40001, "用户不存在"),
    USER_NAME_EXIST(40002, "用户名存在"),
    USERNAME_PASSWORD_FAIL(40003, "用户名或密码错误"),
    USER_TOKEN_VALIDATE_FAIL(40004, "用户token校验失败"),
    USER_ID_TOKEN_NOT_MATCHING(40005, "用户id和token不匹配"),
    USER_ACCOUNT_STYLE_FAIL(40006, "账号格式有误"),
    USER_PASSWORD_IS_EMPTY(40007, "用户密码为空"),
    USER_PASSWORD_LENGTH_FAIL(40008, "用户密码长度必须为6-16位"),
    CODE_MISMATCHING(40009, "验证码不匹配"),
    VALIDATE_CODE_EXPIRED(40010, "验证已码过期"),
    CART_EMPTY(41009, "购物车为空"),
    ORDER_OWNER_ERROR(41010, "该订单不属于该用户"),
    PARAM_ERROR(41011, "参数不正确"),
    ORDER_CANCEL_SUCCESS(41012, "订单取消成功"),
    ORDER_FINISH_SUCCESS(41013, "订单完结成功"),;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
