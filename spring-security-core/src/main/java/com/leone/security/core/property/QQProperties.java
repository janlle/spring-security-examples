package com.leone.security.core.property;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author Leone
 * @since 2018-04-07
 **/
@Data
public class QQProperties extends SocialProperties {

    private String providerId = "qq";


}
