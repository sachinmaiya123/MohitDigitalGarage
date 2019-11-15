package com.quinnox.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.service.entity.DGUser;
import com.quinnox.service.repository.DGUserRepository;

@RequestMapping("/rest")
@RestController
public class LoginController {
	
	@Autowired
	private DGUserRepository userRepository;

	@PostMapping(value="/login", consumes="application/json")
	public String userLogin(@RequestBody DGUser user) {
		String password = user.getUserPassword();
		String userEmail = user.getUserEmail();
		String userName = user.getUserName();
		DGUser activeUser= null;
		
		if(activeUser == null) {
			return "invalid email";
		}
		if(activeUser == null) {
			return "invalid usreName";
		}
		
		if(password != null && userEmail != null){
			activeUser = userRepository.getUserByEmail(userEmail);
			if(activeUser.getUserEmail().equals(userEmail) && activeUser.getUserPassword().equals(password)) {
				return activeUser.getUserId();
			}else {
				return "invalid user";
			}
		}else if (password != null && userName != null) {
			activeUser = userRepository.getUserByUserName(userName);
			if(activeUser.getUserName().equals(userName) && activeUser.getUserPassword().equals(password))  {
				return activeUser.getUserId();
			}else {
				return "invalid user";
			}
		}
		else
			return "UserName/Email or Password is invalid";
		
		
	}
	
}
