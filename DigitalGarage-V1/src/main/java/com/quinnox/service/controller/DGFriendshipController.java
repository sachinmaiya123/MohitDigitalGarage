package com.quinnox.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.service.entity.DGFriend;
import com.quinnox.service.serviceImpl.DGFriendService;

@RestController
@RequestMapping("/rest/friend")
public class DGFriendshipController {

	@Autowired
	private DGFriendService friendService;

	@PostMapping(value = "/addNewFriend", consumes = "application/json")
	public String addNewFriend(@RequestBody DGFriend friend) {
		return friendService.sendFriendRequest(friend);
	}

	@GetMapping(value = "/getAllFriends/{userId}")
	public List<DGFriend> getAllFriendsByUserId(@PathVariable("userId") int userId) {
		return friendService.getAllFriendsByUserId(userId);
	}

	@PostMapping(value = "/changeRequestStatus", consumes = "application/json")
	public String changeRequestStatus(@RequestBody DGFriend friendStatus) {
		System.out.println(friendStatus);
		return friendService.changeFriendRequestStatus(friendStatus.getFriendshipRequestStatus(),
				friendStatus.getUserId(), friendStatus.getUserFriendId());
	}

	@GetMapping(value="/getAllApprovedFriends/{userId}")
	public List<DGFriend> getAllApprovedFriends(@PathVariable("userId") int userId){
		return friendService.getAllApprovedFriends(userId);
	}
	
	@GetMapping(value="/getAllDeniedFriends/{userId}")
	public List<DGFriend> getAllDeniedFriends(@PathVariable("userId") int userId){
		return friendService.getAllDeniedFriends(userId);
	}
	
}
