package com.mikalai.finals.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mikalai.finals.dao.ContactDAO;
import com.mikalai.finals.domain.Contact;
import com.mikalai.finals.domain.Hobby;
import com.mikalai.finals.web.form.AuditContactForm;
import com.mikalai.finals.web.form.ContactGrid;
import com.mikalai.finals.web.form.PageRequest;

import org.springframework.stereotype.Service;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDAO contactDAO;
    


    public List<Hobby> getHobbies() {
        List<Hobby> hobbies = contactDAO.getHobbies();
        return hobbies;
    }

    public List<Contact> getContacts() {
        List<Contact> contacts = contactDAO.getContacts();
        return contacts;
    }

    public List<Contact> getContactsWithDetail() {
        List<Contact> contacts = contactDAO.getContactsWithDetail();
        return contacts;
    }

    public Contact getContactById(Long id) {
        Contact contact = contactDAO.getContactById(id);
        return contact;
    }

    public Contact save(Contact contact) {
        contact = contactDAO.save(contact);
        return contact;
    }

   
    public void delete(Long id) {
        contactDAO.delete(id);

    }

    public List<AuditContactForm> getAuditContacts(Long id) {
        List<AuditContactForm> audit = contactDAO.getAuditContacts(id);
        return audit;
    }
    
    public ContactDAO getContactDAO() {
        return contactDAO;
    }

    public void setContactDAO(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

	@Override
	public ContactGrid findAllByPage(PageRequest pageRequest) {
		ContactGrid contactGrid = contactDAO.findAllByPage(pageRequest);
		return contactGrid;
	}

}
