package com.leone.security.core.social.config;

import com.leone.security.core.property.QQProperties;
import com.leone.security.core.property.SecurityProperties;
import com.leone.security.core.social.qq.connet.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * 微信API调用接口
 * @author Leone
 * @since 2018-05-19 22:18
 **/
@Configuration
@ConditionalOnProperty(prefix = "model.security.social.qq", name = "resource-id")
public class QQAuthConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqConfig = securityProperties.getSocial().getQq();
        return new QQConnectionFactory(qqConfig.getProviderId(),qqConfig.getAppId(),qqConfig.getAppSecret());
    }
}
