/**
 * Created on Oct 18, 2011
 */
package com.mikalai.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.mikalai.spring.domain.Contact;


public interface ContactRepository extends CrudRepository<Contact, Long> {

	
}
