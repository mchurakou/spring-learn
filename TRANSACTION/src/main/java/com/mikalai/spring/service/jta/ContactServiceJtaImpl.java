package com.mikalai.spring.service.jta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mikalai.spring.domain.Contact;
import com.mikalai.spring.service.ContactService;



@Service("contactServiceJta")
@Repository
@Transactional
public class ContactServiceJtaImpl implements ContactService {
    @PersistenceContext(unitName="emfA")
    private EntityManager emA;
    
    @PersistenceContext(unitName="emfB")
    private EntityManager emB;
    


    @Override
    public List<Contact> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Contact findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Contact save(Contact contact) {
        Contact contactB = new Contact();
        contactB.setFirstName(contact.getFirstName());
        contactB.setLastName(contact.getLastName());
        
        if (contact.getId() == null){
            emA.persist(contact);
           // throw new JpaSystemException(new PersistenceException());
            emB.persist(contactB);
        } else {
            emA.merge(contact);
            emB.merge(contactB);
            
        }
            
        
        
        return contact;
    }

    @Override
    public long countAll() {
        // TODO Auto-generated method stub
        return 0;
    }


    public EntityManager getEmA() {
        return emA;
    }

    public void setEmA(EntityManager emA) {
        this.emA = emA;
    }

    public EntityManager getEmB() {
        return emB;
    }

    public void setEmB(EntityManager emB) {
        this.emB = emB;
    }

}
