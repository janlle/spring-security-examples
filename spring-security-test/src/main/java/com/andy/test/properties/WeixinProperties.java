package com.andy.test.properties;

import lombok.Data;

@Data
public class WeixinProperties extends SocialProperties {
	/**
	 * 第三方id，用来决定发起第三方登录的url，默认是 weixin。
	 */
	private String providerId = "weixin";

}
