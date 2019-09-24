package com.quinnox.service.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "dg_friendship")
public class DGFriend implements Serializable {

	@Id
	@Column(name = "friendship_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int friendshipId;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "user_friend_id")
	private int userFriendId;
	@Column(name = "friendship_request_status")
	private String friendshipRequestStatus;

	public int getFriendshipId() {
		return friendshipId;
	}

	public void setFriendshipId(int friendshipId) {
		this.friendshipId = friendshipId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserFriendId() {
		return userFriendId;
	}

	public void setUserFriendId(int userFriendId) {
		this.userFriendId = userFriendId;
	}

	public String getFriendshipRequestStatus() {
		return friendshipRequestStatus;
	}

	public void setFriendshipRequestStatus(String friendshipRequestStatus) {
		this.friendshipRequestStatus = friendshipRequestStatus;
	}

	@Override
	public String toString() {
		return "DGFriend [friendshipId=" + friendshipId + ", userId=" + userId + ", userFriendId=" + userFriendId
				+ ", friendshipRequestStatus=" + friendshipRequestStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + friendshipId;
		result = prime * result + ((friendshipRequestStatus == null) ? 0 : friendshipRequestStatus.hashCode());
		result = prime * result + userFriendId;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DGFriend other = (DGFriend) obj;
		if (friendshipId != other.friendshipId)
			return false;
		if (friendshipRequestStatus == null) {
			if (other.friendshipRequestStatus != null)
				return false;
		} else if (!friendshipRequestStatus.equals(other.friendshipRequestStatus))
			return false;
		if (userFriendId != other.userFriendId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

}
