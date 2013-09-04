package com.mikalai.finals.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;

import org.hibernate.envers.query.AuditQueryCreator;

import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import com.mikalai.finals.domain.Contact;
import com.mikalai.finals.domain.Hobby;
import com.mikalai.finals.domain.audit.RevisionEntity;
import com.mikalai.finals.web.form.AuditContactForm;
import com.mikalai.finals.web.form.ContactGrid;
import com.mikalai.finals.web.form.PageRequest;


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
        logger.info("Retrived count of contacts with detail= " + contacts.size());
        return contacts;
    }

    @Transactional(readOnly=true)
    public Contact getContactById(Long id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().getNamedQuery("Contact.getContactById").setParameter("id", id).uniqueResult();
        logger.info("Retrived contact: " + contact);
        return contact;
    }

    
    public Contact save(Contact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
        logger.info("Contact saved id:" + contact.getId());
        return contact; 

    }

    
    public void delete(Long id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
        sessionFactory.getCurrentSession().delete(contact);
        logger.info("Contact removed id:" + id);
        
    }

    @Transactional(readOnly=true)
    public List<AuditContactForm> getAuditContacts(Long id) {
        AuditReader reader =  AuditReaderFactory.get( sessionFactory.getCurrentSession());
        AuditQueryCreator queryCreator = reader.createQuery();
        List<Object []> audit = queryCreator.forRevisionsOfEntity(Contact.class, false, true).add(AuditEntity.id().eq(id)).getResultList();
        
        List<AuditContactForm> result = new ArrayList<AuditContactForm>();
        for (Object[] a : audit){
            Contact c = (Contact) a[0];
            RevisionEntity re = (RevisionEntity) a[1];
            RevisionType rt = (RevisionType) a[2];
            
            AuditContactForm auditContactForm = new AuditContactForm();
            auditContactForm.setContact(c);
            auditContactForm.setUser(re.getUser());
            auditContactForm.setOpearation(rt.name());
            auditContactForm.setDate(re.getRevisionDate());
            result.add(auditContactForm);
        }
        logger.info("Audit records:" + result.size());
       
        return result;


    }

	@Override
	public ContactGrid findAllByPage(PageRequest pageRequest) {
		int pageNumber = pageRequest.getPageNumber();
		int pageSize = pageRequest.getPageSize();
		int firstResult = pageNumber * pageSize;
		
		
		List<Contact> contacts = sessionFactory.getCurrentSession().createQuery("FROM Contact c order by " + pageRequest.getSortField() + " " + pageRequest.getDirection())
				.setFirstResult(firstResult)
				.setMaxResults(pageSize)
				.list();
		Long totalCount =  (Long) sessionFactory.getCurrentSession().getNamedQuery("Contact.getCount").uniqueResult();
		
		ContactGrid contactGrid = new ContactGrid();
		contactGrid.setCurrentPage(pageNumber + 1);
		contactGrid.setTotalPages((int)Math.ceil(totalCount / (float) pageSize));
		contactGrid.setTotalRecords(totalCount);
		contactGrid.setContactData(contacts);
		return contactGrid;

	}


}
