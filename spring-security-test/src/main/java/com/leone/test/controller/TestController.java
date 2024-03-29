package com.leone.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Leone
 * @since 2017-11-05
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }


    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

}
