package com.andy.security.core.validate.code;

import com.andy.security.core.property.SecurityProperties;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author: lyon
 * @since: 2018-04-07 09:19
 **/
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties properties;

    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(properties.getCode().getSms().getLength());
        return new ValidateCode(code, properties.getCode().getSms().getExpireIn());
    }

    public SecurityProperties getProperties() {
        return properties;
    }

    public void setProperties(SecurityProperties properties) {
        this.properties = properties;
    }
}
