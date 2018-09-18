package com.andy.test.config;

import com.andy.test.authentication.AuthFailureHandler;
import com.andy.test.authentication.AuthSuccessHandler;
import com.andy.test.controller.filter.ValidateCodeFilter;
import com.andy.test.properties.AppSecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

import javax.annotation.Resource;

/**
 * @author lyon
 * @cerateBy: 2018-07-27
 **/
@Configuration
public class TestSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private AuthSuccessHandler authSuccessHandler;

    @Resource
    private AuthFailureHandler authFailureHandler;

    @Resource
    private AppSecurityProperties appSecurityProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();

        validateCodeFilter.setAppSecurityProperties(appSecurityProperties);
        validateCodeFilter.setAuthenticationFailureHandler(authFailureHandler);

        http.formLogin()
//        http.httpBasic()
//                .loginPage("/login-page.html")
//                .loginProcessingUrl("/authentication/form")
//                .loginPage("/authentication/request")
//				.loginProcessingUrl("/authentication/form")
                .failureHandler(authFailureHandler)
                .successHandler(authSuccessHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/login-page.html", "/authentication/request")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RequestCache requestCache() {
        return new HttpSessionRequestCache();
    }

    @Bean
    public RedirectStrategy redirectStrategy() {
        return new DefaultRedirectStrategy();
    }

}
