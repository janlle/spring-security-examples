package com.jja.security.core.validate.code.sms;

/**
 * @author: Mr.ruoLin
 * @createBy: 2018-04-07 10:18
 **/
public interface SmsCodeSender {
    void send(String mobile, String code);
}
