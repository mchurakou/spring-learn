package com.mikalai.spring;

import java.util.List;

import com.mikalai.spring.entity.Contact;



public interface ContactDAO {
    public List<Contact> findAll();
    public List<Contact>findAllWithDetail();
    public Contact findById(Long id);
    public Contact save(Contact contact);
    public void delete(Contact contact);
    

}
