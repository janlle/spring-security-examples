package com.jja.security.core.validate.code;

import com.jja.security.core.properties.SecurityProperties;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author: Mr.ruoLin
 * @createBy: 2018-04-07 09:19
 **/
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties properties;

    public ValidateCode generate(ServletWebRequest request){
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
