package com.andy.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: Mr.lyon
 * @CreateBy: 2018-05-23 22:35
 **/
@Slf4j
@RestController
public class OAuthController {

    @GetMapping("/server/auth")
    public String auth(String code, HttpServletRequest request) {
        String reqUrl = request.getRequestURL().toString();
        log.info("code:{}-----url:{}", code, reqUrl);
        return "success";
    }


}
