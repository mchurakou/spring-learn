package com.mikalai.dao.jdbc.dao;

import java.util.ArrayList;
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

        
        
        Contact c = new Contact();
        c.setId(1l);
        c.setFirstName("Clarence");
        c.setLastName("Peter");
        contactDAO.update(c);
        
        
        c = new Contact();

        c.setFirstName("MIK");
        c.setLastName("CHUR");
        
        
        List<ContactTelDetail> list = new ArrayList<ContactTelDetail>();
        
        ContactTelDetail ctd = new ContactTelDetail();
        ctd.setTelType("home");
        ctd.setTelNumber("11");
        list.add(ctd);
        
        ctd = new ContactTelDetail();
        ctd.setTelType("work");
        ctd.setTelNumber("22");
        list.add(ctd);
        c.setContactTelDetails(list);
        
        contactDAO.insertWithDetail(c);
        
        List<Contact> contacts = contactDAO.findAllWithDetail();
        
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
