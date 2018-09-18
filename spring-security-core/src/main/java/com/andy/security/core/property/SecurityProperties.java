package com.andy.security.core.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lyon
 * @since 2017-11-19 2:30:39
 */
@Data
@ConfigurationProperties(prefix = "module.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    private SocialProperties social = new SocialProperties();

}
