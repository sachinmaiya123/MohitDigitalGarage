package com.quinnox.service.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactional_images")
public class TransactionalImages implements Serializable {

	@Id
	@Column(name = "image_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int imageId;
	@Column(name = "transaction_id")
	private int transactionId;
	@Column(name = "image_url")
	private String imageURL;

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return "TransactionalImages [imageId=" + imageId + ", transactionId=" + transactionId + ", imageURL=" + imageURL
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + imageId;
		result = prime * result + ((imageURL == null) ? 0 : imageURL.hashCode());
		result = prime * result + transactionId;
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
		TransactionalImages other = (TransactionalImages) obj;
		if (imageId != other.imageId)
			return false;
		if (imageURL == null) {
			if (other.imageURL != null)
				return false;
		} else if (!imageURL.equals(other.imageURL))
			return false;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}

}
