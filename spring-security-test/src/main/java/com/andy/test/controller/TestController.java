package com.andy.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lyon
 * @cerateBy: 2018-07-27
 **/
@Slf4j
@RestController
public class TestController {

    @GetMapping("/user")
    public String getUser() {
        return "success";
    }
}
