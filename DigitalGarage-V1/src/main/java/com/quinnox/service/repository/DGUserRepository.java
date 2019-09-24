package com.quinnox.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quinnox.service.entity.DGUser;

@Repository
public interface DGUserRepository extends JpaRepository<DGUser, Integer>{

}
