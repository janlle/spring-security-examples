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
public class TestSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 这里配置了用户名和密码配置文件的就会失效
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin")).roles("admin");
        auth.inMemoryAuthentication().withUser("user").password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("user")).roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/test-login.html", "/authentication/form", "/error/4xx.html")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/test-login.html")
                .loginProcessingUrl("/authentication/form")
                .successForwardUrl("/index")
                .failureUrl("/error/4xx.html")
                .and()
                .logout()
                .logoutUrl("/logout")
                .permitAll()
                .logoutSuccessUrl("/test-logout.html")
                .and()
                .csrf()
                .disable();
    }


}
