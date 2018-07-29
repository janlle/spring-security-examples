package com.andy.test.authentication;

import com.andy.test.common.LoginType;
import com.andy.test.common.Result;
import com.andy.test.properties.AppSecurityProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Mr.lyon
 * @createBy: 2017-11-19 3:12:07
 **/
@Slf4j
@Component("authFailureHandler")
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AppSecurityProperties appSecurityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        log.info("登录失败！");
        if (LoginType.JSON.equals(appSecurityProperties.getBrowser().getLoginType())) {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            response.getWriter().write(objectMapper.writeValueAsString(exception));
            response.getWriter().write(objectMapper.writeValueAsString(Result.build(40000, exception.getMessage(), null)));
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
