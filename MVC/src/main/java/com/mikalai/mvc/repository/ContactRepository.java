
package com.mikalai.mvc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mikalai.mvc.domain.Contact;




public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {

}
