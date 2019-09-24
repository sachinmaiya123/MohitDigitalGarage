package com.quinnox.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quinnox.service.entity.TransactionalImages;
import com.quinnox.service.entity.UserTransaction;

@Repository
public interface TransactionalImagesRepository extends JpaRepository<TransactionalImages, Integer>{

	@Query(nativeQuery=true,value="select * from transactional_images where transaction_id = ?1")
	public List<TransactionalImages> getAllTransactionByTransactionId(int transaction_id);
	
}
