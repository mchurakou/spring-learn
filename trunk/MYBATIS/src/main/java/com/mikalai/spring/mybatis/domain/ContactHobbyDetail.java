package com.mikalai.spring.mybatis.domain;

public class ContactHobbyDetail {
	private Long contactId;
	public Long getContactId() {
		return contactId;
	}
	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
	public String getHobbyId() {
		return hobbyId;
	}
	public void setHobbyId(String hobbyId) {
		this.hobbyId = hobbyId;
	}
	private String hobbyId;
}
