package com.andy.security.core.property;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author: lyon
 * @since: 2018-04-07 14:19
 **/
@Data
public class QQProperties extends SocialProperties {

    private String providerId = "qq";


}
