package com.andy.security.core.properties;

import lombok.Data;

/**
 * @author: Mr.ruoLin
 * @createBy: 2018-04-07 14:21
 **/
@Data
public class SocialProperties {

    private String filterProcessUrl = "/auth";

    private QQProperties qq = new QQProperties();

    private WeixinProperties weixin = new WeixinProperties();

}
