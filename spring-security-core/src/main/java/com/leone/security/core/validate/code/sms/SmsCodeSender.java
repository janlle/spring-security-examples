package com.leone.security.core.validate.code.sms;

/**
 * @author Leone
 * @since 2018-04-07
 **/
public interface SmsCodeSender {
    void send(String mobile, String code);
}
