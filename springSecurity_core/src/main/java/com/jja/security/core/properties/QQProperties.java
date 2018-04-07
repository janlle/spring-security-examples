package com.jja.security.core.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author: Mr.ruoLin
 * @createBy: 2018-04-07 14:19
 **/
@Data
public class QQProperties extends SocialProperties {

    private String providerId = "qq";


}
