package com.mikalai.spring.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mikalai.spring.mybatis.domain.Contact;
import com.mikalai.spring.mybatis.domain.ContactHobbyDetail;
import com.mikalai.spring.mybatis.domain.ContactTelDetail;
import com.mikalai.spring.mybatis.domain.Hobby;
import com.mikalai.spring.mybatis.domain.SearchCriteria;
import com.mikalai.spring.mybatis.persistence.ContactHobbyDetailMapper;
import com.mikalai.spring.mybatis.persistence.ContactMapper;
import com.mikalai.spring.mybatis.persistence.ContactTelDetailMapper;
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
    
    @Autowired
    private ContactTelDetailMapper contactTelDetailMapper;
    
    @Autowired
    private ContactHobbyDetailMapper contactHobbyDetailMapper;

   
  

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

    @Transactional(readOnly=true)
    public Contact save(Contact contact) {
        if (contact.getId() == null) {
        	insert(contact);
        } else {
        	update(contact);
        	
        }
        	
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        Long id = contact.getId();
        contactTelDetailMapper.deleteTelDetailForContact(id);
        contactHobbyDetailMapper.deleteHobbyDetailForContact(id);
        contactMapper.deleteContact(id);

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

    
	public void insert(Contact contact) {
    	contactMapper.insertContact(contact);
    	Long contactId = contact.getId();
    	
    	ContactHobbyDetail chd;
    	
    	if (contact.getContactTelDetails() != null){
            for (ContactTelDetail ctd : contact.getContactTelDetails()){
            	ctd.setContact(contact);
            	contactTelDetailMapper.insertContactTelDetail(ctd);
            }
        }
        
        
        if (contact.getHobbies() != null){
            for (Hobby h : contact.getHobbies()){
            	chd = new ContactHobbyDetail();
            	chd.setContactId(contactId);
            	chd.setHobbyId(h.getHobbyId());
            	contactHobbyDetailMapper.insertContactHobbyDetail(chd);
            }
        }
		
	}
    
    private Contact update(Contact contact) {
		contactMapper.updateContact(contact);
		Long contactId = contact.getId();
		ContactHobbyDetail contactHobbyDetail;
		
		// List storing orphan ids of contact tel details
		List<Long> ids = new ArrayList<Long>();
		
		// Retrieve existing telephones for contact
		List<ContactTelDetail> oldContactTelDetails = contactTelDetailMapper.selectTelDetailForContact(contactId);
	    for (ContactTelDetail contactTelDetail: oldContactTelDetails) {
	    	ids.add(contactTelDetail.getId());
	    }
		
		// Update telephone details
		if (contact.getContactTelDetails() != null) {
			for (ContactTelDetail contactTelDetail: contact.getContactTelDetails()) {
				if (contactTelDetail.getId() == null) {
					contactTelDetailMapper.insertContactTelDetail(contactTelDetail);
				} else {
					contactTelDetailMapper.updateContactTelDetail(contactTelDetail);
					ids.remove(contactTelDetail.getId());
				}
			}
			if (ids.size() > 0) {
				contactTelDetailMapper.deleteOrphanContactTelDetail(ids);
			}
		}
		
		// Update hobby details
		contactHobbyDetailMapper.deleteHobbyDetailForContact(contact.getId());
		if (contact.getHobbies() != null) {
			for (Hobby hobby: contact.getHobbies()) {
				contactHobbyDetail = new ContactHobbyDetail();
				contactHobbyDetail.setContactId(contactId);
				contactHobbyDetail.setHobbyId(hobby.getHobbyId());				
				contactHobbyDetailMapper.insertContactHobbyDetail(contactHobbyDetail);
			}
		}
		
		return contact;
	}
    
    public ContactTelDetailMapper getContactTelDetailMapper() {
		return contactTelDetailMapper;
	}

	public void setContactTelDetailMapper(
			ContactTelDetailMapper contactTelDetailMapper) {
		this.contactTelDetailMapper = contactTelDetailMapper;
	}

	public ContactHobbyDetailMapper getContactHobbyDetailMapper() {
		return contactHobbyDetailMapper;
	}

	public void setContactHobbyDetailMapper(
			ContactHobbyDetailMapper contactHobbyDetailMapper) {
		this.contactHobbyDetailMapper = contactHobbyDetailMapper;
	}

	public ContactMapper getContactMapper() {
        return contactMapper;
    }

    public void setContactMapper(ContactMapper contactMapper) {
        this.contactMapper = contactMapper;
    }




}
