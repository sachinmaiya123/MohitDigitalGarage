package com.quinnox.service.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.service.entity.DGUser;
import com.quinnox.service.serviceImpl.DGUserService;

@RestController
@RequestMapping("/rest/user")
public class DGUserController {

	@Autowired
	private DGUserService userService;
	
	@PostMapping(value="/register", consumes="application/json")
	public JSONObject registerNewUser(@RequestBody DGUser user) {
		System.err.println(user);
		return userService.registerNewUser(user);
	}
	
	@GetMapping(value="/getAllUsers")
	public List<DGUser> getAllRegisteredUsers(){
		return userService.getAllRegisteredUsers();
	}
	
}
