package com.quinnox.service.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quinnox.service.entity.DGFriend;

@Repository
public interface DGFriendRepository extends JpaRepository<DGFriend, Integer> {

	@Query(nativeQuery = true, value = "select * from dg_friendship where user_id = ?1")
	public List<DGFriend> getAllFriendsById(int userId);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(nativeQuery = true, value = "update dg_friendship set friendship_request_status = ?1 where user_id = ?2 and user_friend_id = ?3")
	public int changeFriendRequestStatus(String status, int userId, int userFriendId);

	@Query(nativeQuery = true, value = "select * from dg_friendship where friendship_request_status = 'APPROVED' and user_id = ?1")
	public List<DGFriend> getAllApprovedFriends(int userId);

	@Query(nativeQuery=true, value="select * from dg_friendship where friendship_request_status = 'DENY' and user_id = ?1")
	public List<DGFriend> getAllDeniedFriends(int userId);

}
