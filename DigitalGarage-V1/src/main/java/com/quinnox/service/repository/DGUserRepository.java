package com.quinnox.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quinnox.service.entity.DGUser;

@Repository
public interface DGUserRepository extends JpaRepository<DGUser, String>{
	
	@Query(nativeQuery=true, value="select user_id from dg_users where user_email = ?1")
	public String getUserIdByEmail(String email);
	
	@Query(nativeQuery=true, value="select user_id from dg_users where user_name = ?1")
	public String getUserIdByUserName(String userName);
	
	@Query(nativeQuery=true, value="select * from dg_users where user_email = ?1")
	public DGUser getUserByEmail(String email);
	
	@Query(nativeQuery=true, value="select * from dg_users where user_name = ?1")
	public DGUser getUserByUserName(String userName);

}
