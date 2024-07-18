package com.mediame.mediame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.mediame.mediame.entity.UserEntity;
import com.mediame.mediame.model.User;
import com.mediame.mediame.repository.UserRepository;

@Service(value="userService")
@ComponentScan("com.mediame.mediame.repository.UserRepository")
//@ComponentScan({"com.mediame.mediame.repository"})
public class UserServiceImpl {
	
	@Autowired
	private UserRepository userRepo;
	
	public String createUser(User user) throws Exception {
		
		UserEntity entity = new UserEntity();
		
		entity.setFirstName(user.getFirstName());
		entity.setLastName(user.getLastName());
		entity.setUsername(user.getUsername());
		entity.setPassword(user.getPassword());
		entity.setPhone(user.getPhone());
		entity.setEmail(user.getEmail());
		entity.setUserType(user.getUserType());
		entity.setAddress(user.getAddress());
		entity.setId(0);
		
		userRepo.save(entity);

		return "User with email: "+user.getEmail()+" has been created";
		
	}

}
