package com.quinnox.service.serviceImpl;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.service.entity.DGUser;
import com.quinnox.service.repository.DGUserRepository;

@Service
public class DGUserService {

	@Autowired
	private DGUserRepository userRepository;
	
	public JSONObject registerNewUser(DGUser user) {
		JSONObject result = new JSONObject();
		try {
			 result.put("status",userRepository.save(user).getUserId());
		}catch(Exception e) {e.printStackTrace();
			 result.put("status", "error");
		}
		return result;
	}
	
	public List<DGUser> getAllRegisteredUsers(){
		return userRepository.findAll();
	}
}
