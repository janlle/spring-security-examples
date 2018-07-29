package com.andy.test.authentication;

import com.andy.test.common.LoginType;
import com.andy.test.properties.AppSecurityProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Mr.lyon
 * @createBy: 2017-11-19 2:56:11
 **/
@Slf4j
@Component("authSuccessHandler")
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AppSecurityProperties appSecurityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication)
            throws IOException, ServletException {
        log.info("登录成功！");
        if (LoginType.JSON.equals(appSecurityProperties.getBrowser().getLoginType())) {
            resp.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            resp.getWriter().write(objectMapper.writeValueAsString(authentication));
        } else {
            super.onAuthenticationSuccess(req, resp, authentication);
        }

    }

}
