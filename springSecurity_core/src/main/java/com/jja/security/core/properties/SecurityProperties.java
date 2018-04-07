package com.jja.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ruolin
 * create by 2017年11月19日下午2:30:39
 */
@Data
@ConfigurationProperties(prefix = "ruolin.security")
public class SecurityProperties {

	private BrowserProperties browserProperties = new BrowserProperties();

	private ValidateCodeProperties code = new ValidateCodeProperties();

	private SocialProperties social = new SocialProperties();

}
