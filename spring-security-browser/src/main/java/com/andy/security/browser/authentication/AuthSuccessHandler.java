package com.andy.security.browser.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.andy.security.core.property.LoginType;
import com.andy.security.core.property.SecurityProperties;

/**
 * @author: lyon
 * @since: 2017-11-19 2:56:11
 **/
@Slf4j
@Component("authSuccessHandler")
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication)
            throws IOException, ServletException {
        log.info("登录成功！");
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            resp.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            resp.getWriter().write(objectMapper.writeValueAsString(authentication));
        } else {
            super.onAuthenticationSuccess(req, resp, authentication);
        }

    }

}
