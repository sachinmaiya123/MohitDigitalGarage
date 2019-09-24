package com.quinnox.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quinnox.service.entity.UserTransaction;

@Repository
public interface UserTransactionRepository extends JpaRepository<UserTransaction, Integer>{

	@Query(nativeQuery=true,value="select * from user_transaction where user_id = ?1")
	public List<UserTransaction> getAllTransactionByUserId(int userId);
	
}
