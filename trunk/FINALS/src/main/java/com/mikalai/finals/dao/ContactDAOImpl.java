package com.mikalai.finals.dao;

import java.util.List;




import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;

import org.hibernate.envers.query.AuditQueryCreator;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import com.mikalai.finals.domain.Contact;
import com.mikalai.finals.domain.Hobby;


@Repository("contactDAO")
@Transactional
public class ContactDAOImpl implements ContactDAO {

    private static final Logger logger = Logger.getLogger(ContactDAOImpl.class);
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
        List<Hobby> hobbies = sessionFactory.getCurrentSession().createQuery("FROM Hobby h").list();
        logger.info("Retrived count of hobbies= " + hobbies.size());
        return hobbies;
    }

    @Transactional(readOnly=true)
    public List<Contact> getContacts() {
        List<Contact> contacts = sessionFactory.getCurrentSession().createQuery("FROM Contact c").list();
        logger.info("Retrived count of contacts= " + contacts.size());
        return contacts;
    }

    @Transactional(readOnly=true)
    public List<Contact> getContactsWithDetail() {
        List<Contact> contacts = sessionFactory.getCurrentSession().getNamedQuery("Contact.getContactsWithDetail").list();
        logger.info("Retrived count of contacts= " + contacts.size());
        return contacts;
    }

    @Transactional(readOnly=true)
    public Contact getContactById(Long id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().getNamedQuery("Contact.getContactById").setParameter("id", id).uniqueResult();
        logger.info("Retrived contact: " + contact);
        return contact;
    }

    @Transactional
    public Contact save(Contact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
        logger.info("Contact saved id:" + contact.getId());
        return contact; 

    }

    @Transactional
    public void delete(Long id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
        sessionFactory.getCurrentSession().delete(contact);
        logger.info("Contact removed id:" + id);
        
    }

    @Transactional
    public List<Object []> getAuditContacts(Long id) {
        AuditReader reader =  AuditReaderFactory.get( sessionFactory.getCurrentSession());
        AuditQueryCreator queryCreator = reader.createQuery();
        List<Object []> result = queryCreator.forRevisionsOfEntity(Contact.class, false, true).add(AuditEntity.id().eq(id)).getResultList();
        logger.info("Audit records:" + result.size());
        return result;

    }


}
