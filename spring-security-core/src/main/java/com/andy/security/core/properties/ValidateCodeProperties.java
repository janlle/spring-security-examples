package com.andy.security.core.properties;

import lombok.Data;

/**
 * @author: Mr.ruoLin
 * @createBy: 2018-04-07 07:59
 **/
@Data
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    private SmsCodeProperties sms = new SmsCodeProperties();

}
