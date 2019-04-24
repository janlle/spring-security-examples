package com.leone.security.core.property;

import lombok.Data;

/**
 * @author Leone
 * @since 2018-04-07 14:21
 **/
@Data
public class SocialProperties {

    private String filterProcessUrl = "/auth";

    private QQProperties qq = new QQProperties();

    private WxProperties wx = new WxProperties();

}
