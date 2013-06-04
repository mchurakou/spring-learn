package com.mikalai.spring.service;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mikalai.spring.domain.Contact;

public class Run {

    /**
     * @param args
     */
    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:tx-annotation-app-context.xml");
        ctx.refresh();
        
        ContactService contactService = ctx.getBean("contactService", ContactService.class);

        // Testing findAll() method
        /*List<Contact> contacts = contactService.findAll();
        
        for (Contact contactTemp: contacts) {
            System.out.println(contactTemp);
        }     */
        
        // Testing save() method
      Contact contact = contactService.findById(1l);
        contact.setFirstName("Peter");
        contactService.save(contact);
        System.out.println("Contact saved successfully");   
        
        // Testing countAll() method
       long l =contactService.countAll();
       System.out.println("Contact count: " + l);  

    }

}
