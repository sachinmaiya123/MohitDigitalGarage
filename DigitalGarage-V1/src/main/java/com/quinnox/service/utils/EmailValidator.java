package com.quinnox.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quinnox.service.serviceImpl.DGUserService;

@Component
public class EmailValidator {

	private String email;
	
	@Autowired
	private DGUserService userService;

	@Override
	public String toString() {
		return "EmailValidator [email=" + email + "]";
	}

	public boolean doesUserExists(String email) {
		boolean flag = false;
		String userIDByEmail = userService.getUserIDByEmail(email);
		if(userIDByEmail != null) {
			flag = true;
		}
		return flag;
	}
}
