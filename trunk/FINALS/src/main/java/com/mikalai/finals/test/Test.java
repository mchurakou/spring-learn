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
import com.mikalai.finals.domain.User;
import com.mikalai.finals.domain.audit.RevisionEntity;
import com.mikalai.finals.service.ContactService;
import com.mikalai.finals.web.form.AuditContactForm;



public class Test {

    public static void main(String[] args) throws InterruptedException {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("h2");
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();
        
                
        
        ContactService contactService = ctx.getBean("contactService", ContactService.class);
        
        List<Hobby> hobbies = contactService.getHobbies();
        
        System.out.println("Hobbies:");
        
        for (Hobby h : hobbies){
            System.out.println(h);
        }
        
        List<Contact> contacts = contactService.getContactsWithDetail();
        //List<Contact> contacts = contactDAO.getContacts();
        
        
        System.out.println("Contacts:");
        
        for (Contact c : contacts){
            System.out.println(c);
        }
        
        
        Contact contact = contactService.getContactById(1L);
        System.out.println("Contact1:" + contact);
        
        if (contact != null){
        
            contact.setFirstName("TEST1");
            contactService.save(contact);
            contact = contactService.getContactById(1L);
            System.out.println("Contact2:" + contact);
        }
        
       
        
        Contact newContact =  new Contact();
        newContact.setFirstName("UNO");
        newContact.setLastName("DUE");
        newContact.setBirthDate(new Date());
        contactService.save(newContact);
        Thread.sleep(1000);
        newContact.setFirstName("MODIFIED");
        contactService.save(newContact);
        
        Thread.sleep(3000);
        
        newContact = contactService.getContactById(newContact.getId());
        System.out.println("NEW CONTACT:" + newContact);
        
        contactService.delete(newContact.getId());
        System.out.println("Deleted");
        
        
        System.out.println("Audit:");
        
        
        List<AuditContactForm> audit = contactService.getAuditContacts(newContact.getId());
        
        for (AuditContactForm a : audit){
            
           System.out.println(a.getContact() + " | " + a.getUserName() + "|" + a.getOpearation() + "|" + a.getDate());

                
        }
        System.out.println("Finish");
        
        
        
        
        
        
        


    }

}
