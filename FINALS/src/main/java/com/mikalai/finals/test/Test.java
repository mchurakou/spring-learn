package com.mikalai.finals.test;

import java.util.Date;
import java.util.List;

import org.hibernate.envers.RevisionType;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import com.mikalai.finals.dao.ContactDAO;
import com.mikalai.finals.domain.Contact;
import com.mikalai.finals.domain.Hobby;
import com.mikalai.finals.domain.audit.RevisionEntity;



public class Test {

    public static void main(String[] args) throws InterruptedException {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("mysql");
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();
        
                
        
        ContactDAO contactDAO = ctx.getBean("contactDAO", ContactDAO.class);
        
        List<Hobby> hobbies = contactDAO.getHobbies();
        
        System.out.println("Hobbies:");
        
        for (Hobby h : hobbies){
            System.out.println(h);
        }
        
        List<Contact> contacts = contactDAO.getContactsWithDetail();
        //List<Contact> contacts = contactDAO.getContacts();
        
        
        System.out.println("Contacts:");
        
        for (Contact c : contacts){
            System.out.println(c);
        }
        
        
        Contact contact = contactDAO.getContactById(1L);
        System.out.println("Contact1:" + contact);
        
        if (contact != null){
        
        contact.setFirstName("TEST1");
        contactDAO.save(contact);
        contact = contactDAO.getContactById(1L);
        System.out.println("Contact2:" + contact);
        }
        
       
        
        Contact newContact =  new Contact();
        newContact.setFirstName("UNO");
        newContact.setLastName("DUE");
        newContact.setBirthDate(new Date());
        contactDAO.save(newContact);
        
        newContact.setFirstName("MODIFIED");
        contactDAO.save(newContact);
        
        Thread.sleep(5000);
        
        newContact = contactDAO.getContactById(newContact.getId());
        System.out.println("NEW CONTACT:" + newContact);
        
        contactDAO.delete(newContact);
        System.out.println("Deleted");
        
        
        System.out.println("Audit:");
        
        
        List<Object []> audit = contactDAO.getAuditContacts(1L);
        
        for (Object[] a : audit){
            Contact c = (Contact) a[0];
            RevisionEntity re = (RevisionEntity) a[1];
            RevisionType rt = (RevisionType) a[2];
            
            System.out.println(c.show() + " | " + re.getUser() + "|" + rt.name() + "|" + re.getRevisionDate());
        }
        System.out.println("Finish");
        
        
        
        
        


    }

}
