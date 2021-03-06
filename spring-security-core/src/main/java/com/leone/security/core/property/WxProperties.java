package com.leone.security.core.property;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

@Data
public class WxProperties extends SocialProperties {

	/**
	 * 第三方id，用来决定发起第三方登录的url，默认是 weixin。
	 */
	private String providerId = "weixin";

}
