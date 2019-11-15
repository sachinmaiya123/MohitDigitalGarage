package com.quinnox.service.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.service.entity.DGUser;
import com.quinnox.service.serviceImpl.DGUserService;
import com.quinnox.service.utils.EmailValidator;
import com.quinnox.service.utils.UserNameValidator;

@RestController
@RequestMapping("/rest/user")
public class DGUserController {

	@Autowired
	private DGUserService userService;

	@Autowired
	private EmailValidator emailValidator;

	@Autowired
	private UserNameValidator userNameValidator;

	@PostMapping(value = "/register", consumes = "application/json")
	public JSONObject registerNewUser(@RequestBody DGUser user) {
		JSONObject result = new JSONObject();
		if (emailValidator.doesUserExists(user.getUserEmail())) {
			  result.put("userID", "email already registered");
		} else {
			if(userNameValidator.isUserNameRegistered(user.getUserName())) {
			  result.put("userID", "userName already registered");
			}else {
				userService.registerNewUser(user);
				result.put("userID", user.getUserId());
			}
		}
		return result;
	}

	@PostMapping(value = "/login", consumes = "application/json")
	public void loginUser(@RequestBody DGUser user) {
		// to implement
	}

	@GetMapping(value = "/getAllUsers")
	public List<DGUser> getAllRegisteredUsers() {
		return userService.getAllRegisteredUsers();
	}
	
	@PatchMapping(value="/updateData")
	public DGUser udpateUserData(@RequestBody DGUser user) {
		return userService.updateUserData(user);
	}

}
