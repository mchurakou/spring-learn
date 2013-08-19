package com.mikalai.finals.dao;

import java.util.List;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.mikalai.finals.domain.Contact;
import com.mikalai.finals.domain.Hobby;

@Repository("contactDAO")
@Transactional
public class ContactDAOImpl implements ContactDAO {

    private Log log = LogFactory.getLog(ContactDAOImpl.class);
    
    @PersistenceContext
    private EntityManager em;
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }


    
    
    @Transactional(readOnly=true)
    public List<Hobby> getHobbies() {
        System.out.println("Entered in ContactDAOImpl.getHobbies()");
        List<Hobby> hobbies = em.createQuery("FROM Hobby h").getResultList();
        System.out.println("Hobbies retrived: " + hobbies.size());
        return hobbies;
    }

    @Transactional(readOnly=true)
    public List<Contact> getContacts() {
        System.out.println("Entered in ContactDAOImpl.getContacts()");
        List<Contact> contacts = em.createQuery("FROM Contact c").getResultList();
        System.out.println("Retrived count of contacts= " + contacts.size());
        return contacts;
    }

    @Transactional(readOnly=true)
    public List<Contact> getContactsWithDetail() {
        System.out.println("Entered in ContactDAOImpl.getContactsWithDetail()");
        List<Contact> contacts = em.createNamedQuery("Contact.getContactsWithDetail", Contact.class).getResultList();
        System.out.println("Retrived count of contacts= " + contacts.size());
        return contacts;
    }

    @Transactional(readOnly=true)
    public Contact getContactById(Long id) {
        System.out.println("Entered in ContactDAOImpl.getContactById()");
        
        Contact contact = null;
        try {
            TypedQuery<Contact> query = em.createNamedQuery("Contact.getContactById", Contact.class);
            query.setParameter("id", id);
            contact = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Contact was not found");
        }
        
        System.out.println("Retrived contact: " + contact);
        return contact;

    }


    public Contact save(Contact contact) {
        System.out.println("Entered in ContactDAOImpl.save()");
        if (contact.getId() == null){
            System.out.println("new");
            em.persist(contact);
            
        } else{
            em.merge(contact);
            System.out.println("update");
        }
        System.out.println("Contact saved id:" + contact.getId());
        return contact;
        
        


    }

    public void delete(Contact contact) {
        
        Contact d = em.find(Contact.class, contact.getId());
        //Contact mergedContact = em.merge(contact);
        em.remove(d);
        System.out.println("Contact removed id:" + contact.getId());
    }
    



}
