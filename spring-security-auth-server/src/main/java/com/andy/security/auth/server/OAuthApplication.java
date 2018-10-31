package com.andy.security.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * <p> 认证服务器
 *
 * @author Leone
 * @since 2018-05-05
 **/
@SpringBootApplication
@EnableAuthorizationServer
public class OAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuthApplication.class, args);
    }
}