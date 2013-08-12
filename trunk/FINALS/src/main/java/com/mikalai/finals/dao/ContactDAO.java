package com.mikalai.finals.dao;

import java.util.List;

import com.mikalai.finals.domain.Contact;
import com.mikalai.finals.domain.Hobby;





public interface ContactDAO {
    public List<Hobby> getHobbies();
    public List<Contact> getContacts();
    public List<Contact> getContactsWithDetail();

    

}
