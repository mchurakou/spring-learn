
package com.mikalai.spring.service;

import java.util.List;

import com.mikalai.spring.domain.Contact;




public interface ContactService {

	public List<Contact> findAll();
	
	public Contact findById(Long id);
	
	public Contact save(Contact contact);
	
	public long countAll();
}
