package com.andy.web.controller;

import com.andy.entity.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {

	@GetMapping("/user")
	public Users getUser() {
		Users user = new Users();
		user.setSalary(1000);
		user.setId(12);
		user.setUsername("tom");
		user.setBirthday(new Date());
		user.setPassword("ddeedeba");
		return user;
	}

}
