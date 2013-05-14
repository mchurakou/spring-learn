package com.mikalai.spring.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mikalai.spring.domain.Contact;
import com.mikalai.spring.domain.Contact_;

@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
    final static String ALL_CONTACT_NATIVE_QUERY = "select id, first_name, last_name, birth_date, versiom from contact";
    
    private Log log = LogFactory.getLog(ContactServiceImpl.class);
    
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly=true)
    public List<Contact> findAll() {
        List<Contact> contacts = em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
        return contacts;
    }

    @Transactional(readOnly=true)
    public List<Contact> findAllWithDetail() {
        List<Contact> contacts = em.createNamedQuery("Contact.findAllWithDetail", Contact.class).getResultList();
        return contacts;
    }

    @Transactional(readOnly=true)
    public Contact findById(Long id) {
        TypedQuery<Contact> query = em.createNamedQuery("Contact.findById", Contact.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Contact save(Contact contact) {
        if (contact.getId() == null){
            log.info("new");
            em.persist(contact);
        } else{
            em.merge(contact);
            log.info("update");
        }
        return contact;
            
    }

    @Override
    public void delete(Contact contact) {
        Contact mergedContact = em.merge(contact);
        em.remove(mergedContact);
        log.info("deleted:" + contact);

    }

    @Transactional(readOnly=true)
    public List<Contact> findAllByNativeQuery() {
        return em.createNamedQuery(ALL_CONTACT_NATIVE_QUERY, Contact.class).getResultList();
    }

    @Transactional(readOnly=true)
    public List<Contact> findByCtiteriaQuery(String firstName, String lastName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Contact> criteriaQuery = cb.createQuery(Contact.class);
        Root<Contact> contactRoot = criteriaQuery.from(Contact.class);
        contactRoot.fetch(Contact_.contactTelDetails, JoinType.LEFT);
        contactRoot.fetch(Contact_.hobbies, JoinType.LEFT);
        criteriaQuery.select(contactRoot).distinct(true);
        Predicate criteria = cb.conjunction();
        
        if (firstName != null){
            Predicate p = cb.equal(contactRoot.get(Contact_.firstName), firstName);
            criteria = cb.and(criteria, p);
        }
        
        if (lastName != null){
            Predicate p = cb.equal(contactRoot.get(Contact_.lastName), lastName);
            criteria = cb.and(criteria, p);
        }
        
        criteriaQuery.where(criteria);
        List<Contact> res = em.createQuery(criteriaQuery).getResultList();
        return res;
        
    }



}
