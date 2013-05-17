package com.mikalai.spring.jpa;

import java.util.List;

import com.mikalai.spring.domain.Contact;

public interface ContactService {
    public List<Contact> findAll();
    public List<Contact>findAllWithDetail();
    public Contact findById(Long id);
    public Contact save(Contact contact);
    public void delete(Contact contact);
    
    public List<Contact> findAllByNativeQuery();
    
    public List<Contact> findByFirstName(String firstName);
    public List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
    
    public List<Contact> findByCtiteriaQuery(String firstName, String lastName);
}
