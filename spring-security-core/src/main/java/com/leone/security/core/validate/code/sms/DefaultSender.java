package com.leone.security.core.validate.code.sms;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Leone
 * @since 2018-04-07
 **/
@Slf4j
public class DefaultSender implements SmsCodeSender {

    @Override
    public void send(String phone, String code) {
        log.info("send sms to: {} code: {}", phone, code);
    }

}
