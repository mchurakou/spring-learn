package com.mikalai.finals.web.form;

import java.util.Date;

import com.mikalai.finals.domain.Contact;
import com.mikalai.finals.domain.User;

public class AuditContactForm {
	private Contact contact;
	private User user;
	private String opearation;
	private Date date;
	
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOpearation() {
		return opearation;
	}
	public void setOpearation(String opearation) {
		this.opearation = opearation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
