
package com.mikalai.integration.service;

import java.util.List;

import com.mikalai.integration.domain.Contact;




public interface ContactService {

	public List<Contact> findAll();
	
	public List<Contact> findByFirstName(String firstName);
	
	public Contact findById(Long id);
	
	public Contact save(Contact contact);
	
	public void delete(Contact contact);
	
}
