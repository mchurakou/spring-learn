package com.mikalai.finals.dao;

import java.util.List;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import com.mikalai.finals.domain.Contact;
import com.mikalai.finals.domain.Hobby;


@Repository("contactDAO")
@Transactional
public class ContactDAOImpl implements ContactDAO {

    private Log log = LogFactory.getLog(ContactDAOImpl.class);
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    @Override
    public List<Hobby> getHobbies() {
        log.info("Entered in ContactDAOImpl.getHobbies()");
        List<Hobby> hobbies = sessionFactory.getCurrentSession().createQuery("FROM Hobby h").list();
        log.info("Retrived count of hobbies= " + hobbies.size());
        return hobbies;
    }

    @Override
    public List<Contact> getContacts() {
        log.info("Entered in ContactDAOImpl.getContacts()");
        List<Contact> contacts = sessionFactory.getCurrentSession().createQuery("FROM Contact c").list();
        log.info("Retrived count of contacts= " + contacts.size());
        return contacts;
    }

    @Override
    public List<Contact> getContactsWithDetail() {
        log.info("Entered in ContactDAOImpl.getContactsWithDetail()");
        List<Contact> contacts = sessionFactory.getCurrentSession().getNamedQuery("Contact.getContactsWithDetail").list();
        log.info("Retrived count of contacts= " + contacts.size());
        return contacts;
    }


}
