package com.andy.security.core.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Mr.lyon
 * @createBy 2017年11月19日下午2:30:39
 */
@Data
@ConfigurationProperties(prefix = "andy.security")
public class SecurityProperties {

	private BrowserProperties browser = new BrowserProperties();

	private ValidateCodeProperties code = new ValidateCodeProperties();

	private SocialProperties social = new SocialProperties();

}
