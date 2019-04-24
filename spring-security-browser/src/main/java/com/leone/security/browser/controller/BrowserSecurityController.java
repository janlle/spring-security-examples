package com.leone.security.browser.controller;

import com.leone.security.core.common.Response;
import com.leone.security.core.property.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Leone
 * @since 2017-11-19
 */
@Slf4j
@RestController
public class BrowserSecurityController {

    @Autowired
    private RequestCache requestCache;

    @Autowired
    private RedirectStrategy redirectStrategy;

    @Autowired
    private SecurityProperties securityProperties;


    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @GetMapping("/authentication/request")
    public Response requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String target = savedRequest.getRedirectUrl();
            log.info("引发的跳转请求是：" + target);
            if (StringUtils.endsWithIgnoreCase(target, ".html")) {
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
            }
        }
        return Response.build(40001, "访问的内容需要身份认证，请到登录页面认证！");
    }


}
