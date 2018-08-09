package com.andy.test.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: lyon
 * @since: 2017-11-19 2:30:39
 */
@Data
@Component
@ConfigurationProperties(prefix = "module.security")
public class AppSecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

//    private SocialProperties social = new SocialProperties();

}
