package com.andy.security.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.andy.security.core.properties.SecurityProperties;

/**
 * @Description:
 * @Author: Mr.lyon
 * @CreateBy: 2018-05-19 22:18
 **/
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

	
	
}
