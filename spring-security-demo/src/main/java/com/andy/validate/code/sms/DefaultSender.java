package com.andy.validate.code.sms;

/**
 * @author: Mr.lyon
 * @createBy: 2018-04-07 10:19
 **/
public class DefaultSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        System.out.println("向"+mobile+"发送短信验证码："+code);
    }
}
