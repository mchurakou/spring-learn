package com.mikalai.spring.mybatis;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mikalai.spring.mybatis.domain.Contact;
import com.mikalai.spring.mybatis.domain.ContactTelDetail;
import com.mikalai.spring.mybatis.domain.Hobby;



public class Run {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context.xml");
        ctx.refresh();
        
        ContactService contactService = ctx.getBean("contactService", ContactService.class);
        
        //List<Contact> list = contactService.findAll();
        //List<Contact> list = contactService.findAllWithDetail();
        
        List<Contact> list = contactService.findByFirstNameAndLastName("Clarence", "Ho");
        
        System.out.println("RESULT:");
        for (Contact c : list){
            System.out.println("CONTACT:");
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
        
        Contact newC = new Contact();
        newC.setFirstName("MIKALAI");
        newC.setLastName("Churakou");
        
        ContactTelDetail ctd = new ContactTelDetail();
        ctd.setTelNumber("23");
        ctd.setTelType("home");
        Set<ContactTelDetail> ctds = new HashSet<ContactTelDetail>();
        ctds.add(ctd);
        newC.setContactTelDetails(ctds);
        
        
        Hobby h = new Hobby();
        h.setHobbyId("Jogging");
        Set<Hobby> hs = new HashSet<Hobby>();
        hs.add(h);
        newC.setHobbies(hs);
        
        contactService.save(newC);
        
        System.out.println("BY ID:");
        Contact c = contactService.findById(newC.getId());
        System.out.println(c);
        
        
        System.out.println("UPDATING");
        c.setFirstName("CHANGED");
        contactService.save(c);
        c = contactService.findById(newC.getId());
        System.out.println(c);
        
        System.out.println("DELTETING");
        contactService.delete(c);
        
        
        
      
    }

}
