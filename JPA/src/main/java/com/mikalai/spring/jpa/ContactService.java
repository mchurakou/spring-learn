package com.mikalai.spring.jpa;

import java.util.List;

import com.mikalai.spring.domain.Contact;

public interface ContactService {
    public List<Contact> findAll();
    public List<Contact>findAllWithDetail();
    public Contact findById(Long id);
    public Contact save(Contact contact);
    public void delete(Contact contact);
}
