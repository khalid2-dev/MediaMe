package com.mediame.mediame.model;

import java.util.List;

import com.mediame.mediame.entity.UserEntity;

public class UpdateRequest {

	private String email;
	private UserEntity updateRequest;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserEntity getUpdateRequest() {
		return updateRequest;
	}
	public void setUpdateRequest(UserEntity updateRequest) {
		this.updateRequest = updateRequest;
	}
	
}
