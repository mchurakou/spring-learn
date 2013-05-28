package com.mikalai.spring.mybatis;

import java.util.Date;
import java.util.List;

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
        
        
        System.out.println("BY ID:");
        Contact c = contactService.findById(1l);
        System.out.println(c);
        
      
    }

}
