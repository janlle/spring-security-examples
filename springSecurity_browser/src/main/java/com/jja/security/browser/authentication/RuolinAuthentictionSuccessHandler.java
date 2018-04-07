package com.jja.security.browser.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jja.security.core.properties.LoginType;
import com.jja.security.core.properties.SecurityProperties;

/**
 * @author ruolin create by 2017年11月19日下午2:56:11
 */
@Component("ruolinAuthentictionSuccessHandler")
// public class RuolinAuthentictionSuccessHandler implements
// AuthenticationSuccessHandler {
public class RuolinAuthentictionSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	private Logger logger = LoggerFactory.getLogger(RuolinAuthentictionSuccessHandler.class);

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private SecurityProperties securityProperties;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication)
			throws IOException, ServletException {
		logger.info("登录成功！");

		if (LoginType.JSON.equals(securityProperties.getBrowserProperties().getLoginType())) {
			resp.setContentType("application/json;charset=utf-8");
			resp.getWriter().write(objectMapper.writeValueAsString(authentication));
		} else {
			super.onAuthenticationSuccess(req, resp, authentication);
		}

	}

}
