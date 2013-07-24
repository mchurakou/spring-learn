
package com.mikalai.mvc.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mikalai.mvc.domain.Contact;




public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
	public List<Contact> findByFirstNameAndLastName(String firstName, String lastName);

}
