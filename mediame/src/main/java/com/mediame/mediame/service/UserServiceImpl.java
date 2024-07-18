package com.mediame.mediame.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.mediame.mediame.entity.UserEntity;
import com.mediame.mediame.model.LoginRequest;
import com.mediame.mediame.model.Response;
import com.mediame.mediame.model.UpdateRequest;
import com.mediame.mediame.model.User;
import com.mediame.mediame.repository.UserRepository;

@Service(value="userService")
@ComponentScan("com.mediame.mediame.repository.UserRepository")
//@ComponentScan({"com.mediame.mediame.repository"})
public class UserServiceImpl {
	
	@Autowired
	private UserRepository userRepo;
	
	public UserEntity findUser(String email) {
		UserEntity entity = userRepo.findByEmail(email);
		if(entity != null) {
			System.out.println("USER ID: "+entity.getId());
			return entity;
		}
		return null;
	}
	
	public String createUser(User user) throws Exception {
		
		UserEntity entity = new UserEntity();
		
		if(findUser(user.getEmail()) == null) {
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
		
		return "Cannot create the user as user already exists!";
		
	}

	public String deleteUser(User user) {
		UserEntity entity = findUser(user.getEmail());
		if(entity != null) {
			userRepo.delete(entity);
			return "User with email: "+user.getEmail()+" has been deleted";
		}
		return "User with email: "+user.getEmail()+" does not exist!";
	}
	
	public String updateUser(UpdateRequest request) throws IOException {
		UserEntity entity = findUser(request.getEmail());
		if(entity != null) {
			//userRepo.updateUserDetails(entity);
			if(request.getUpdateRequest().getAddress() != null) {
				entity.setAddress(request.getUpdateRequest().getAddress());
			}
			if(request.getUpdateRequest().getFirstName() != null) {
				entity.setFirstName(request.getUpdateRequest().getFirstName());
			}
			if(request.getUpdateRequest().getLastName() != null) {
				entity.setLastName(request.getUpdateRequest().getLastName());
			}
			if(request.getUpdateRequest().getLastName() != null) {
				entity.setPassword(request.getUpdateRequest().getPassword());
			}
			if(request.getUpdateRequest().getPhone() != null) {
				entity.setPhone(request.getUpdateRequest().getPhone());
			}
			if(request.getUpdateRequest().getUserType() != null) {
				entity.setUserType(request.getUpdateRequest().getUserType());
			}
			userRepo.save(entity);
			return "User with email: "+request.getUpdateRequest().getEmail()+" has been updated";
		}
		return "User with email: "+request.getUpdateRequest().getEmail()+" does not exist!";
	}
	
	public Response userLogin(LoginRequest login) {
		Response response = new Response();
		UserEntity entity = findUser(login.getEmail());
		User user = new User();
		if(entity != null) {
			if(entity.getPassword().equals(login.getPassword())) {
				user.setFirstName(entity.getFirstName());
				user.setLastName(entity.getLastName());
				user.setAddress(entity.getAddress());
				user.setPhone(entity.getPhone());
				user.setUserType(entity.getUserType());
				response.setUser(user);
				response.setMessage("Welcome "+user.getFirstName());
				return response;
			} else {
				response.setUser(null);
				response.setMessage("Invalid log in details!");
				return response;
			}
		}
		response.setUser(null);
		response.setMessage("Invalid log in details!");
		return response;
	}

}
