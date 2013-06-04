package com.mikalai.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.mikalai.spring.domain.Contact;
import com.mikalai.spring.repository.ContactRepository;


@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
    
    @Autowired
    private ContactRepository contactRepository;

    @Transactional(readOnly=true)
    public List<Contact> findAll() {
       return  Lists.newArrayList(contactRepository.findAll());
    }


    @Transactional(readOnly=true)
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public Contact save(Contact contact) {
       return  contactRepository.save(contact);
    }

    @Transactional(propagation=Propagation.NEVER)
    public long countAll() {
        return contactRepository.countAllContacts();
    }
    

    public ContactRepository getContactRepository() {
        return contactRepository;
    }

    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

}
