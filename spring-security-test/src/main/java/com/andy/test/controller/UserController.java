package com.andy.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Leone
 * @since 2017-11-05
 */
@Slf4j
@RestController
public class UserController {

    @GetMapping("/user")
    public String getUser() {
        return "user";
    }

}
