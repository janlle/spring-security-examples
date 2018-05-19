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
@Configuration
@Slf4j
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SecurityProperties securityProperties;
	@Autowired
	private AuthenticationSuccessHandler ruolinAuthentictionSuccessHandler;
	@Autowired
	private AuthenticationFailureHandler ruolinAuthenticationFailureHandler;

	@Autowired
	private DataSource dataSource;


	@Autowired
	private UserDetailsService userDetailsService;


	@Autowired
	private SpringSocialConfigurer ruolinSecuritySocialConfig;

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

		ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
		validateCodeFilter.setProperties(securityProperties);
		validateCodeFilter.setAuthenticationFailureHandler(ruolinAuthenticationFailureHandler);
		validateCodeFilter.afterPropertiesSet();

		log.info("配置文件中的登录页面是：" + securityProperties.getBrowserProperties().getLoginPage());
		http.apply(ruolinSecuritySocialConfig)
				.and()
				.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
				.formLogin()
	//				.loginPage("/andy-login.html")
					.loginPage("/authentication/request")
					.loginProcessingUrl("/authentication/form")
					.successHandler(ruolinAuthentictionSuccessHandler)
					.failureHandler(ruolinAuthenticationFailureHandler)
					.and()
				.rememberMe()
					.tokenRepository(persistentTokenRepository())
					.tokenValiditySeconds(securityProperties.getBrowserProperties().getRememberMeSeconds())
					.userDetailsService(userDetailsService)
					.and()
				.authorizeRequests()
					.antMatchers("/authentication/request", securityProperties.getBrowserProperties().getLoginPage(), "/code/*")
					.permitAll()
					.anyRequest()
					.authenticated()
					.and()
					.csrf().disable();

	}

}
