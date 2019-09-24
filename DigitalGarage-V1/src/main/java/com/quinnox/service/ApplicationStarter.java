package com.quinnox.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.quinnox.service.entity.DGUser;
import com.quinnox.service.serviceImpl.DGUserService;

@SpringBootApplication
public class ApplicationStarter {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationStarter.class, args);
		System.err.println("Application started successfully...");
		
	}

}
