package com.jja.security.browser.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.jja.security.browser.support.SimpleResponse;
import com.jja.security.core.properties.SecurityProperties;
/**
 * @author ruolin
 * create by 2017年11月19日下午2:08:28
 */
@Slf4j
@RestController
public class BrowserSecurityController {
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Autowired
	private SecurityProperties securityProperties;
	
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	@GetMapping("/authentication/request")
	public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException{
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		if(savedRequest != null){
			String target = savedRequest.getRedirectUrl();
				log.info("引发的跳转请求是："+target);
				if(StringUtils.endsWithIgnoreCase(target, ".html")){
				redirectStrategy.sendRedirect(request, response, securityProperties.getBrowserProperties().getLoginPage());
			}
		}
		return new SimpleResponse("访问的内容需要身份认证，请到登录页面认证！");
	}

}
