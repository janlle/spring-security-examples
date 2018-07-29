package com.andy.test.properties;

import lombok.Data;

/**
 * @author: Mr.lyon
 * @createBy: 2018-04-07 07:59
 **/
@Data
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    private SmsCodeProperties sms = new SmsCodeProperties();

}
