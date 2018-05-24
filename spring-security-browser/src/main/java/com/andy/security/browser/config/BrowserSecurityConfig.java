package com.andy.security.browser.config;

import com.andy.security.core.validate.code.ValidateCodeFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import com.andy.security.core.properties.SecurityProperties;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * @author ruolin
 * create by 2017年11月12日上午8:36:39
 */
@Slf4j
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SecurityProperties securityProperties;
	@Autowired
	private AuthenticationSuccessHandler authSuccessHandler;
	@Autowired
	private AuthenticationFailureHandler authFailureHandler;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private UserDetailsService userDetailsService;


	@Autowired
	private SpringSocialConfigurer andySecuritySocialConfig;

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
//		tokenRepository.setCreateTableOnStartup(true);
		return tokenRepository;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
//
//		validateCodeFilter.setProperties(securityProperties);
//		validateCodeFilter.setAuthenticationFailureHandler(authFailureHandler);
//		validateCodeFilter.afterPropertiesSet();
		log.info("配置文件中的登录页面是：" + securityProperties.getBrowser().getLoginPage());
//		http.apply(andySecuritySocialConfig)
//			.and()
//			.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
//			.formLogin()
////				.loginPage("/andy-login.html")
//				.loginPage("/authentication/request")
//				.loginProcessingUrl("/authentication/form")
//				.successHandler(ruolinAuthentictionSuccessHandler)
//				.failureHandler(ruolinAuthenticationFailureHandler)
//				.and()
//			.rememberMe()
//				.tokenRepository(persistentTokenRepository())
//				.tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
//				.userDetailsService(userDetailsService)
//				.and()
//			.authorizeRequests()
//				.antMatchers("/authentication/request", securityProperties.getBrowser().getLoginPage(), "/code/*")
//				.permitAll()
//				.anyRequest()
//				.authenticated()
//				.and()
//				.csrf()
//			.disable();
		http.formLogin()
				.successHandler(authSuccessHandler)
				.failureHandler(authFailureHandler)
				.loginPage("/andy-login.html")
				.loginProcessingUrl("/authentication/form")
				.and()
				.authorizeRequests()
				.antMatchers("/andy-login.html")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.csrf()
				.disable();



	}

}
