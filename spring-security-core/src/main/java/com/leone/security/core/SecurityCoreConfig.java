package com.leone.security.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.leone.security.core.property.SecurityProperties;

/**
 * @author Leone
 * @since 2018-02-19
 **/
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}
