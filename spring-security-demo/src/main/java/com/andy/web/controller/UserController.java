package com.andy.web.controller;

import com.andy.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: lyon
 * @since 2017-11-5 2:14:58
 */
@Slf4j
@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser() {
        User user = new User("james", "james", "james", "james@gmail.com", "he");
        return user;
    }

}
