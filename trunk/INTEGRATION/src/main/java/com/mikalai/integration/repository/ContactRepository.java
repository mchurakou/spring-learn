
package com.mikalai.integration.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mikalai.integration.domain.Contact;


public interface ContactRepository extends CrudRepository<Contact, Long> {

	public List<Contact> findByFirstName(String firstName);
	
}
