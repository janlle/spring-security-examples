package com.jja.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jja.web.filter.TimeFilter;
import com.jja.web.interceptor.TimeInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	private TimeInterceptor timeInterceptor;
	
	@Bean
	public FilterRegistrationBean timeFilter(){
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
}
