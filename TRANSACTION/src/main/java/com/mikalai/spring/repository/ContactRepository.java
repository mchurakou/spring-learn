/**
 * Created on Oct 18, 2011
 */
package com.mikalai.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.mikalai.spring.domain.Contact;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    @Query("select count(c) from Contact c")
    public Long countAllContacts();
	
}
