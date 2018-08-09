package com.andy.test.properties;

import lombok.Data;

/**
 * @author: lyon
 * @since: 2018-04-07 14:21
 **/
@Data
public class SocialProperties {

    private String filterProcessUrl = "/auth";

    private QQProperties qq = new QQProperties();

    private WeixinProperties wx = new WeixinProperties();

}
