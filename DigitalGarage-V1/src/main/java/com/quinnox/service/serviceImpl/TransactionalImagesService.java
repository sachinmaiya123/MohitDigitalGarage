package com.quinnox.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.service.entity.TransactionalImages;
import com.quinnox.service.repository.TransactionalImagesRepository;

@Service
public class TransactionalImagesService {

	@Autowired
	private TransactionalImagesRepository transactionalImagesRepository;
	
	public String addImages(TransactionalImages image) {
		try {
			transactionalImagesRepository.save(image);
			return "successful";
		}catch(Exception e) {e.printStackTrace();
		  return "error";
		}
	}
	
	public List<TransactionalImages> getAllImagesByTransactionId(int transactionId){
		return transactionalImagesRepository.getAllTransactionByTransactionId(transactionId);
	}
}
