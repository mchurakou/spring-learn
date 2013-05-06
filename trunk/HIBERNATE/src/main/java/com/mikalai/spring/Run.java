package com.mikalai.spring;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;



import com.mikalai.spring.ContactDAO;
import com.mikalai.spring.entity.Contact;
import com.mikalai.spring.entity.ContactTelDetail;
import com.mikalai.spring.entity.Hobby;

public class Run {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context.xml");
        ctx.refresh();
        
        ContactDAO contactDAO = ctx.getBean("contactDAO", ContactDAO.class);
        List<Contact> list = contactDAO.findAllWithDetail();
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
        contactDAO.save(n);
        
        Contact contact = contactDAO.findById(n.getId());
        System.out.println("ID:" + contact);
        
        contactDAO.delete(contact);
        
        


    }

}
