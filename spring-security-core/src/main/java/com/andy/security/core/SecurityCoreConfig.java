package com.andy.security.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.andy.security.core.property.SecurityProperties;

/**
 * @author: Mr.lyon
 * @createBy: 2018-02-19 22:18
 **/
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {


}
