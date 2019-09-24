package com.quinnox.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.service.entity.TransactionalImages;
import com.quinnox.service.entity.UserTransaction;
import com.quinnox.service.repository.TransactionalImagesRepository;
import com.quinnox.service.serviceImpl.TransactionalImagesService;
import com.quinnox.service.serviceImpl.UserTransactionService;

@RestController
@RequestMapping("/rest/transaction")
public class UserTransactionController {
	
	private List<String> imageList;
	
	// constructor
	public UserTransactionController() {
		imageList = new ArrayList<String>();
	}

	@Autowired
	private UserTransactionService transactionService;
	
	@Autowired
	private TransactionalImagesService imageService;
	
	@GetMapping(value="/getAllTransactions/{userId}")
	public List<UserTransaction> getAllTransactionsByUserId(@PathVariable("userId") int userId){
		 List<UserTransaction> transactionList = transactionService.getAllTransactionsByUserId(userId);
		 for(UserTransaction transaction : transactionList){
			 List<String> urlList = new ArrayList<>();
			 List<TransactionalImages> imageList = imageService.getAllImagesByTransactionId(transaction.getTransactionId());
			 	for(TransactionalImages image : imageList){
			 		urlList.add(image.getImageURL());
			 	}
			 	
			 transaction.setImageURLS(urlList);	
		 }
		 return transactionList;
	}
	
	@PostMapping(value="/addTransaction",consumes="application/json")
	public String makeTransaction(@RequestBody UserTransaction transaction) {
		 imageList = transaction.getImageURLS();
		 int transactionID = transactionService.saveTransaction(transaction);
		 return saveImageURLS(transactionID, imageList);
	}
	
	@GetMapping("/getTransaction/{transactionId}")
	public UserTransaction getTransactionByTransactionId(@PathVariable("transactionId") int transactionId) {
		UserTransaction transaction = transactionService.getTransactionByTransactionId(transactionId); 
		List<String> urls = new ArrayList<>();
		List<TransactionalImages> images = imageService.getAllImagesByTransactionId(transactionId);
		for(TransactionalImages image : images) {
			urls.add(image.getImageURL());
		}
		transaction.setImageURLS(urls);
		return transaction;
	}
	
	public String saveImageURLS(int transactionId,List<String> imageURLS) {
		try {
			for(String image : imageURLS){
				TransactionalImages tImages = new TransactionalImages();
				tImages.setTransactionId(transactionId);
				tImages.setImageURL(image);
				System.err.println(imageService.addImages(tImages));
			}
			return "successful "+ "transactionId : "+transactionId;
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	
}
