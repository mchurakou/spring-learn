package com.mikalai.spring.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mikalai.spring.domain.Contact;
import com.mikalai.spring.domain.ContactAudit;
import com.mikalai.spring.domain.ContactTelDetail;
import com.mikalai.spring.domain.Hobby;

public class Run {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context.xml");
        ctx.refresh();
        
        ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);
        ContactAuditService contactAuditService = ctx.getBean("contactAuditService", ContactAuditService.class);
        
        List<Contact> list = contactService.findAllWithDetail();
        
        //List<Contact> list = contactService.findByFirstNameAndLastName("John", "Smith");
        for (Contact c : list){
            System.out.println(c);
            if (c.getContactTelDetails() != null){
                System.out.println("CTD:");
                for (ContactTelDetail ctd : c.getContactTelDetails()){
                    System.out.println(ctd);
                }
            }
            
            
            if (c.getHobbies() != null){
                System.out.println("H:");
                for (Hobby h : c.getHobbies()){
                    System.out.println(h);
                }
            }

            
        }
        
        Contact n = new Contact();
        n.setFirstName("MIKOLA");
        n.setLastName("CHURAKOY");
        contactService.save(n);
        
        Contact contact = contactService.findById(n.getId());
        System.out.println("ID:" + contact);
        
        contactService.delete(contact);
        
        ContactAudit contactAudit = new ContactAudit();
        contactAudit.setFirstName("FEDOR");
        contactAudit.setLastName("UZD");
        contactAudit.setBirthDate(new Date());
        contactAuditService.save(contactAudit);
        System.out.println("AUDIT:");
        List<ContactAudit> listA = contactAuditService.findAll();
        for (ContactAudit ca : listA){
            System.out.println(ca);
        }

    }

}
