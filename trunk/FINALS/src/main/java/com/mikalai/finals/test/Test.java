package com.mikalai.finals.test;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mikalai.finals.dao.ContactDAO;
import com.mikalai.finals.domain.Contact;
import com.mikalai.finals.domain.Hobby;



public class Test {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();
        
        ContactDAO contactDAO = ctx.getBean("contactDAO", ContactDAO.class);
        
        List<Hobby> hobbies = contactDAO.getHobbies();
        
        System.out.println("Hobbies:");
        
        for (Hobby h : hobbies){
            System.out.println(h);
        }
        
        List<Contact> contacts = contactDAO.getContactsWithDetail();
        
        System.out.println("Contacts:");
        
        for (Contact c : contacts){
            System.out.println(c);
        }
        
        
        


    }

}
