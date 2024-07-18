package com.mediame.mediame.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mediame.mediame.entity.UserEntity;
import com.mediame.mediame.model.UpdateRequest;
import com.mediame.mediame.model.User;
import com.mediame.mediame.service.UserServiceImpl;

@RestController
@ComponentScan("com.mediame.mediame.service.UserServiceImpl")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/create")
	public String createUser(@RequestBody User user) throws Exception {
		//System.out.println("USER FIRST NAME: "+user.getFirstName());
		return userService.createUser(user);
	}
	
	@DeleteMapping("/delete")
	public String deleteUser(@RequestBody User user) {
		return userService.deleteUser(user);
	}
	
	//To modify: search by email instead of whole USER object
	@GetMapping("/findUser")
	public UserEntity findUserByEmail(@RequestBody User user) {
		return userService.findUser(user.getEmail());
	}
	
	@PutMapping("/update")
	public String updateUser(@RequestBody UpdateRequest request) {
		try { 
			return userService.updateUser(request);
		} catch(IOException e) {
			return "Error updating user: " + e.getMessage();
		}
	}

}
