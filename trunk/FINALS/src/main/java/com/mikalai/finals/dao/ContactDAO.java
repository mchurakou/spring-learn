package com.mikalai.finals.dao;

import java.util.List;

import com.mikalai.finals.domain.Contact;
import com.mikalai.finals.domain.Hobby;





public interface ContactDAO {
    public List<Hobby> getHobbies();
    public List<Contact> getContacts();
    public List<Contact> getContactsWithDetail();
    public Contact getContactById(Long id);
    public Contact save(Contact contact);
    public void delete(Long id);
    
    public List<Object []> getAuditContacts(Long id);
    

}
