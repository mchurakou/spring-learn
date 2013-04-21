package com.mikalai.dao.jdbc.dao;


import java.util.Date;
import java.util.List;

import com.mikalai.dao.jdbc.bean.Contact;

public class Run {

    private static ContactDAO cantactDAO = new PlainContactDAO();
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("All:");
        List<Contact> all =  cantactDAO.findAll();
        
        for (Contact contact : all){
            System.out.println(contact);
        }
        
        System.out.println("New");
        Contact c1 = new Contact();
        c1.setFirstName("ZEEDER");
        c1.setLastName("fFF");
        c1.setBirthDate(new Date());
        cantactDAO.insert(c1);
        
        System.out.println("All:");
        all =  cantactDAO.findAll();
        
        for (Contact contact : all){
            System.out.println(contact);
        }
        
        System.out.println("Delete:");
        cantactDAO.delete(c1.getId());
        
        System.out.println("All:");
        all =  cantactDAO.findAll();
        
        for (Contact contact : all){
            System.out.println(contact);
        }
        

    }

}
