package com.andy.security.core.property;

import lombok.Data;

/**
 * @author: Mr.ruoLin
 * @createBy: 2018-04-07 07:58
 **/
@Data
public class SmsCodeProperties {

    private int length = 6;

    private int expireIn = 60;

    private String url;
}
