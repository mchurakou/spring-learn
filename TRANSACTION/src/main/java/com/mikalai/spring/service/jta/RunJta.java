package com.mikalai.spring.service.jta;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mikalai.spring.domain.Contact;
import com.mikalai.spring.service.ContactService;

public class RunJta {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:tx-jta-app-context.xml");
        ctx.refresh();
        
        ContactService contactService = ctx.getBean("contactServiceJta", ContactService.class);
        
        Contact contact = new Contact();
        contact.setFirstName("MikolaC");
        contact.setLastName("ChurakouC");
        contactService.save(contact);
        System.out.println("FINISHED");
 

    }

}
