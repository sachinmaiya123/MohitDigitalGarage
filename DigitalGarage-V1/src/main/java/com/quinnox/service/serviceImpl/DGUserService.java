package com.quinnox.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.service.entity.DGUser;
import com.quinnox.service.repository.DGUserRepository;
import com.quinnox.service.repository.UserTransactionRepository;

@Service
public class DGUserService {

	@Autowired
	private DGUserRepository userRepository;

	public JSONObject registerNewUser(DGUser user) {
		JSONObject result = new JSONObject();
		try {
			result.put("status", userRepository.save(user).getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "error");
		}
		return result;
	}

	public List<DGUser> getAllRegisteredUsers() {
		return userRepository.findAll();
	}

	public String getUserIDByEmail(String email) {
		return userRepository.getUserIdByEmail(email);
	}

	public String getUserIDByUserName(String userName) {
		return userRepository.getUserIdByUserName(userName);
	}

	public DGUser updateUserData(DGUser user) {
		Optional<DGUser> optional = userRepository.findById(user.getUserId());
		DGUser dgUser = optional.get();
		if (user.getUserPassword() != null) {
			dgUser.setUserPassword(user.getUserPassword());
		}
		if (user.getUserEmail() != null) {
			dgUser.setUserEmail(user.getUserEmail());
		}
		if (user.getUserFirstName() != null) {
			dgUser.setUserFirstName(user.getUserFirstName());
		}
		if (user.getUserLastName() != null) {
			dgUser.setUserLastName(user.getUserLastName());
		}
		if (user.getUserName() != null) {
			dgUser.setUserName(user.getUserName());
		}
		System.err.println(dgUser);
		return userRepository.save(dgUser);
	}
	
	public DGUser getUserByEmailId(String email) {
		DGUser user = null;
		try {
			user = userRepository.getUserByEmail(email);
			return user;
		}catch(Exception e) {
			e.printStackTrace();
			return user;
		}
		 
	}
}
