package com.andy.security.core.validate.code.sms;

/**
 * @author: lyon
 * @since: 2018-04-07 10:18
 **/
public interface SmsCodeSender {
    void send(String mobile, String code);
}
