package com.leone.security.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.leone.security.web.filter.TimeFilter;
import com.leone.security.web.interceptor.TimeInterceptor;

import javax.annotation.Resource;

/**
 * @author Leone
 * @since 2018-01-26
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Resource
    private TimeInterceptor timeInterceptor;

    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean filterBean = new FilterRegistrationBean(new TimeFilter());
        List<String> urls = new ArrayList<String>();
        urls.add("/*");
        filterBean.setUrlPatterns(urls);
        return filterBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
