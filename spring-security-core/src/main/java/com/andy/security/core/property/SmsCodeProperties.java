package com.andy.security.core.property;

import lombok.Data;

/**
 * @author Leone
 * @since 2018-04-07
 **/
@Data
public class SmsCodeProperties {

    private int length = 6;

    private int expireIn = 60;

    private String url;
}
