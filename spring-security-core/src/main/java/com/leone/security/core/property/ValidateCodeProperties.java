package com.leone.security.core.property;

import lombok.Data;

/**
 * @author Leone
 * @since 2018-04-07
 **/
@Data
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    private SmsCodeProperties sms = new SmsCodeProperties();

}
