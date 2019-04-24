package com.leone.security.auth.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author Leone
 * @since 2018-05-23
 **/
@Order
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 添加客户端信息使用in-memory存储客户端信息
        clients.inMemory()
                .withClient("client")
                .secret("secret")
                // 该client允许的授权类型
                .authorizedGrantTypes("authorization_code")
                // 允许的授权范围
                .scopes("all");
    }

}
