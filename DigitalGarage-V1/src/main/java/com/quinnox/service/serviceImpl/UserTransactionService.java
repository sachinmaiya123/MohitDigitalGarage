package com.quinnox.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.service.entity.UserTransaction;
import com.quinnox.service.repository.UserTransactionRepository;

@Service
public class UserTransactionService {

	@Autowired
	private UserTransactionRepository transactionRepository;
	
	public List<UserTransaction> getAllTransactionsByUserId(String userId){
		return transactionRepository.getAllTransactionByUserId(userId);
	}
	
	public int saveTransaction(UserTransaction transaction) {
		return transactionRepository.save(transaction).getTransactionId();
	}
	
	public UserTransaction getTransactionByTransactionId(int transactionId) {
		Optional<UserTransaction> optional = transactionRepository.findById(transactionId);
		return optional.get();
	}
	
}
