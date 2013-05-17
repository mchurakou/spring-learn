package com.mikalai.spring.jpa.repository;

import java.util.List;

import com.mikalai.spring.domain.Contact;
import org.springframework.data.repository.CrudRepository;
public interface ContactRepository extends CrudRepository<Contact, Long> {
    public List<Contact> findByFirstName(String firstName);
    public List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
