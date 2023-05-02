package com.leone.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author leone
 * @since 2023-05-01
 **/
@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @ResponseBody
    @GetMapping("/user/hello")
    public String hello1() {
        return "user hello";
    }

    @ResponseBody
    @GetMapping("/admin/hello")
    public String hello2() {
        return "admin hello";
    }

    @ResponseBody
    @GetMapping("/db/hello")
    public String hello3() {
        return "db hello";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "logout";
    }

}