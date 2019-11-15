package com.quinnox.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quinnox.service.serviceImpl.DGUserService;

@Component
public class UserNameValidator {

	private String userName;
	@Autowired
	private DGUserService userService;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public boolean isUserNameRegistered(String userName) {
		boolean flag = false;
		String userId = userService.getUserIDByUserName(userName);
		if(userId != null) {
			flag = true;
		}
		return flag;
	}
	
}
