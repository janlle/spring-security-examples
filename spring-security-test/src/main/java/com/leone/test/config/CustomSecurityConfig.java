package com.leone.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

/**
 * <p>自定义安全配置
 *
 * @author leone
 * @since 2019-04-26
 **/
@Configuration
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin")).roles("admin");
        auth.inMemoryAuthentication().withUser("user").password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("user")).roles("user");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/custom-login.html", "/authentication/form", "/custom-failed.html")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/custom-login.html")
                .loginProcessingUrl("/authentication/form")
                .successForwardUrl("/index")
                .failureUrl("/custom-failed.html")
                .and()
                .logout()
                .logoutUrl("/logout")
                .permitAll()
                .logoutSuccessUrl("/custom-logout.html")
                .and()
                .csrf()
                .disable();
    }


}
