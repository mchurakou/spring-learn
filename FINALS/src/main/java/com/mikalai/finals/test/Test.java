package com.mikalai.finals.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mikalai.finals.dao.ContactDAO;
import com.mikalai.finals.domain.Contact;
import com.mikalai.finals.domain.Hobby;




public class Test {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("h2");
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();
        
        ContactDAO contactDAO = ctx.getBean("contactDAO", ContactDAO.class);
        
        System.out.println("ALL HOBBIES:");
        List<Hobby> hobbies = contactDAO.getHobbies();
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
        
        
        contact.setFirstName("TEST1");
        contactDAO.save(contact);
                
        contact = contactDAO.getContactById(1L);
        System.out.println("Contact2:" + contact);
        
        Contact newContact =  new Contact();
        newContact.setFirstName("UNO1");
        newContact.setLastName("UNO1");
        newContact.setBirthDate(new Date());
        
        contactDAO.save(newContact);
        
        newContact.setFirstName("DUE2");
        newContact.setLastName("DUE2");
        contactDAO.save(newContact);
        

        
        contactDAO.delete(contact);
        System.out.println("Deleted");
        

        

        
        
        
        
        


    }

}
