package com.mikalai.dao.jdbc.dao;

import java.util.List;

import com.mikalai.dao.jdbc.bean.Contact;

public interface ContactDAO {
    public List<Contact> findAll();
    public List<Contact> findByFirstName(String firstName);
    public void insert(Contact contact);
    public void update(Contact contact);
    public void delete(Long contactID);
    
    public String findFirstNamebyId(Long id);
}
