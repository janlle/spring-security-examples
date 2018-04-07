package com.jja.security.core.social.ocnfig;

import com.jja.security.core.properties.QQProperties;
import com.jja.security.core.properties.SecurityProperties;
import com.jja.security.core.social.qq.connet.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @author: Mr.ruolin
 * @createBy: 2018-04-7 14:17
 **/
@Configuration
@ConditionalOnProperty(prefix = "ruolin.security.social.qq", name = "app-id")
public class QQAuthConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqConfig = securityProperties.getSocial().getQq();
        return new QQConnectionFactory(qqConfig.getProviderId(),qqConfig.getAppId(),qqConfig.getAppSecret());
    }
}
