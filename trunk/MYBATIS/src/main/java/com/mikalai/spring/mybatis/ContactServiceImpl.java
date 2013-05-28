package com.mikalai.spring.mybatis;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mikalai.spring.mybatis.domain.Contact;
import com.mikalai.spring.mybatis.domain.ContactTelDetail;
import com.mikalai.spring.mybatis.domain.SearchCriteria;
import com.mikalai.spring.mybatis.persistence.ContactMapper;
import com.sun.corba.se.pept.broker.Broker;
import com.sun.corba.se.pept.encoding.InputObject;
import com.sun.corba.se.pept.encoding.OutputObject;
import com.sun.corba.se.pept.protocol.ClientRequestDispatcher;
import com.sun.corba.se.pept.protocol.MessageMediator;
import com.sun.corba.se.pept.transport.Connection;
import com.sun.corba.se.pept.transport.ContactInfo;
import com.sun.corba.se.pept.transport.ContactInfoList;
import com.sun.corba.se.pept.transport.OutboundConnectionCache;


@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
    
    private Log log = LogFactory.getLog(ContactServiceImpl.class);
    
    @Autowired
    private ContactMapper contactMapper;

    public ContactMapper getContactMapper() {
        return contactMapper;
    }

    public void setContactMapper(ContactMapper contactMapper) {
        this.contactMapper = contactMapper;
    }

  

    @Transactional(readOnly=true)
    public List<Contact> findAll() {
        List<Contact> contacts = contactMapper.findAll();
        return contacts;
    }

    @Transactional(readOnly=true)
    public List<Contact> findAllWithDetail() {
        List<Contact> contacts = contactMapper.findAllWithDetail();
        for (Contact c : contacts){
            populate(c);
        }
        return contacts;
    }
    
    private void populate(Contact c){
        if (c.getContactTelDetails() != null){
            for (ContactTelDetail ctd : c.getContactTelDetails()){
                ctd.setContact(c);
            }
        }
    }

    @Transactional(readOnly=true)
    public Contact findById(Long id) {
        Contact contact = contactMapper.findById(id);
        populate(contact);

        return contact;
    }

    @Override
    public Contact save(Contact contact) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Contact contact) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Contact> findByFirstNameAndLastName(String firstName,
            String lastName) {
        SearchCriteria sc = new SearchCriteria();
        sc.setFirstName(firstName);
        sc.setLastName(lastName);
        
        List<Contact> contacts = contactMapper.findByFirstNameAndLastName(sc);
        for (Contact c : contacts){
            populate(c);
        }
        return contacts;
    }


}
