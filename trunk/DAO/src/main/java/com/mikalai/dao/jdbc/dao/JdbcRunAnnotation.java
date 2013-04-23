package com.mikalai.dao.jdbc.dao;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mikalai.dao.jdbc.bean.Contact;
import com.mikalai.dao.jdbc.bean.ContactTelDetail;

public class JdbcRunAnnotation {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();
        
        ContactDAO contactDAO = ctx.getBean("contactDAO", ContactDAO.class);

        List<Contact> contacts = contactDAO.findByFirstName("Clarence");
        
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
