package com.quinnox.service.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "user_transaction")
@Entity
public class UserTransaction implements Serializable{

	@Id
	@Column(name = "transaction_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionId;
	@Column(name = "transaction_title")
	private String transactionTitle;
	@Column(name = "transaction_date")
	private String transactionDate;
	private String latitude;
	private String longitude;
	private float amount;
	@Column(name = "transaction_note")
	private String transactionNote;
	@Column(name = "user_id")
	private String userId;
	@Transient
	private List<String> imageURLS;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionTitle() {
		return transactionTitle;
	}

	public void setTransactionTitle(String transactionTitle) {
		this.transactionTitle = transactionTitle;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getTransactionNote() {
		return transactionNote;
	}

	public void setTransactionNote(String transactionNote) {
		this.transactionNote = transactionNote;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getImageURLS() {
		return imageURLS;
	}

	public void setImageURLS(List<String> imageURLS) {
		this.imageURLS = imageURLS;
	}

	@Override
	public String toString() {
		return "UserTransaction [transactionId=" + transactionId + ", transactionTitle=" + transactionTitle
				+ ", transactionDate=" + transactionDate + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", amount=" + amount + ", transactionNote=" + transactionNote + ", userId=" + userId + ", imageURLS="
				+ imageURLS + "]";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserTransaction other = (UserTransaction) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (imageURLS == null) {
			if (other.imageURLS != null)
				return false;
		} else if (!imageURLS.equals(other.imageURLS))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (transactionNote == null) {
			if (other.transactionNote != null)
				return false;
		} else if (!transactionNote.equals(other.transactionNote))
			return false;
		if (transactionTitle == null) {
			if (other.transactionTitle != null)
				return false;
		} else if (!transactionTitle.equals(other.transactionTitle))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

}
