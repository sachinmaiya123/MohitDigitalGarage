package com.quinnox.service.controller;

import static org.hamcrest.CoreMatchers.containsString;

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
	  String key = null;
	  String response = null;
	  DGUser dbUser = null;
	  
	  // check to userName/email is not null ==========================
	  
	  if(user.getUserEmail() != null){
		  System.err.println("email is entered");
		  key = user.getUserEmail();
		    if(user.getUserPassword() != null) {
		    	try {
		    		dbUser =  userRepository.getUserByEmail(key);
		    		if(user.getUserEmail().equals(dbUser.getUserEmail()) && user.getUserPassword().equals(dbUser.getUserPassword())){
		    			response = dbUser.getUserId();
		    		}else {
		    			response = "Invalid userName or password";
		    		}
		    	}catch(Exception e) {
		    		response =  "Invalid userName or password";
		    	}
		    }
		    return response;
	  }else if(user.getUserName() != null){
		  System.err.println("userName is entered");
		  key = user.getUserName();
		    if(user.getUserPassword() != null) {
		    	try {
		    		dbUser =  userRepository.getUserByUserName(key);
		    		if(user.getUserName().equals(dbUser.getUserName()) && user.getUserPassword().equals(dbUser.getUserPassword())){
		    			response = dbUser.getUserId();
		    		}else {
		    			response = "Invalid userName or password";
		    		}
		    	}catch(Exception e) {
		    		response =  "Invalid userName or password";
		    	}
		    }
		    return response;
	  }
	  else
		  return "UserName or Email can not be empty";
	  	
	}
	
}
