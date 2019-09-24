package com.quinnox.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.service.entity.DGFriend;
import com.quinnox.service.repository.DGFriendRepository;

@Service
public class DGFriendService {

	@Autowired
	private DGFriendRepository friendRepository;

	public String sendFriendRequest(DGFriend friend) {
		try {
			friendRepository.save(friend);
			return "friend request sent successfully...";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public List<DGFriend> getAllFriendsByUserId(int userId) {
		try {
			return friendRepository.getAllFriendsById(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String changeFriendRequestStatus(String status, int userId, int userFriendId) {
		try {
			friendRepository.changeFriendRequestStatus(status, userId, userFriendId);
			return "status changed successfully...";
		} catch (Exception e) {
			e.printStackTrace();
			return "error in setting new status...";
		}
	}

	public List<DGFriend> getAllApprovedFriends(int userId) {
		try {
			return friendRepository.getAllApprovedFriends(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<DGFriend> getAllDeniedFriends(int userId) {
		try {
			return friendRepository.getAllDeniedFriends(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
