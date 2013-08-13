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
    
    
    @Transactional(readOnly=true)
    public List<Hobby> getHobbies() {
        log.info("Entered in ContactDAOImpl.getHobbies()");
        List<Hobby> hobbies = sessionFactory.getCurrentSession().createQuery("FROM Hobby h").list();
        log.info("Retrived count of hobbies= " + hobbies.size());
        return hobbies;
    }

    @Transactional(readOnly=true)
    public List<Contact> getContacts() {
        log.info("Entered in ContactDAOImpl.getContacts()");
        List<Contact> contacts = sessionFactory.getCurrentSession().createQuery("FROM Contact c").list();
        log.info("Retrived count of contacts= " + contacts.size());
        return contacts;
    }

    @Transactional(readOnly=true)
    public List<Contact> getContactsWithDetail() {
        log.info("Entered in ContactDAOImpl.getContactsWithDetail()");
        List<Contact> contacts = sessionFactory.getCurrentSession().getNamedQuery("Contact.getContactsWithDetail").list();
        log.info("Retrived count of contacts= " + contacts.size());
        return contacts;
    }

    @Transactional(readOnly=true)
    public Contact getContactById(Long id) {
        log.info("Entered in ContactDAOImpl.getContactById()");
        Contact contact = (Contact) sessionFactory.getCurrentSession().getNamedQuery("Contact.getContactById").setParameter("id", id).uniqueResult();
        log.info("Retrived contact: " + contact);
        return contact;
    }

    @Transactional
    public Contact save(Contact contact) {
        log.info("Entered in ContactDAOImpl.save()");
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
        log.info("Contact saved id:" + contact.getId());
        return contact; 

    }

    @Transactional
    public void delete(Contact contact) {
        sessionFactory.getCurrentSession().delete(contact);
        log.info("Contact removed id:" + contact.getId());
    }


}
