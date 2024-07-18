package com.mediame.mediame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mediame.mediame.model.User;
import com.mediame.mediame.service.UserServiceImpl;

@RestController
@ComponentScan("com.mediame.mediame.service.UserServiceImpl")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/create")
	public String createUser(@RequestBody User user) throws Exception {
		System.out.println("USER FIRST NAME: "+user.getFirstName());
		return userService.createUser(user);
	}

}
