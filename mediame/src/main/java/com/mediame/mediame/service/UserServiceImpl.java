package com.mediame.mediame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.mediame.mediame.model.User;
import com.mediame.mediame.repository.UserRepository;

@Service(value = "userService")
@ComponentScan("om.mediame.mediame.repository.UserRepository")
//@ComponentScan({"com.mediame.mediame.repository"})
public abstract class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	public String createUser(User user) {
		userRepo.findById(null);
		return "";
	}

}
