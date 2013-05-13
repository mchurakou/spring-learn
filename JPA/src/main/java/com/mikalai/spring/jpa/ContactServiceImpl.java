package com.mikalai.spring.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mikalai.spring.domain.Contact;

@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
    
    private Log log = LogFactory.getLog(ContactServiceImpl.class);
    
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Contact> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Contact> findAllWithDetail() {
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Contact contact) {
        // TODO Auto-generated method stub

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
