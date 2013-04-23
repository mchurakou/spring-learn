package com.mikalai.dao.jdbc.dao;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mikalai.dao.jdbc.bean.Contact;
import com.mikalai.dao.jdbc.bean.ContactTelDetail;

public class JdbcRun {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context.xml");
        ctx.refresh();
        
        ContactDAO contactDAO = ctx.getBean("contactDAO", ContactDAO.class);
        System.out.println("NAME:" + contactDAO.findFirstNamebyId(1l));
        System.out.println("LAST:" + contactDAO.findLastNamebyId(1l));
        
        List<Contact> contacts = contactDAO.findAll();
        
        for (Contact contact : contacts) {
        	System.out.println(contact);
        	if (contact.getContactTelDetails() != null){
        		for (ContactTelDetail detail : contact.getContactTelDetails()){
        			System.out.println("---" + detail);
        		}
        	}
        }
    }

}
