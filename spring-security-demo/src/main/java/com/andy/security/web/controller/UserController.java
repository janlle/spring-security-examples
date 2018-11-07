package com.andy.security.web.controller;

import com.andy.security.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Leone
 * @since 2017-11-05
 */
@Slf4j
@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser() {
        return new User("james", "james", "james", 23, new Date(), false);
    }

}
