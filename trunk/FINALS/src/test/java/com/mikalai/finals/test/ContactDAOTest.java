package com.mikalai.finals.test;



import java.util.Date;


import java.util.List;


import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import com.mikalai.finals.dao.ContactDAO;
import com.mikalai.finals.domain.Contact;
import com.mikalai.finals.domain.Hobby;
import com.mikalai.finals.domain.Telephon;



@ContextConfiguration(locations={"classpath:/spring/app-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("h2")
public class ContactDAOTest {

	@Autowired
	private ContactDAO contactDAO;



    @Test
	@Transactional
	public void testAllHobbiess() throws Exception {
	    List<Hobby> hobbies = contactDAO.getHobbies();
		
		Assert.assertNotNull(hobbies);
		Assert.assertTrue(hobbies.size() > 0);
	}
    
    @Test
    @Transactional
    public void testAllContacts() throws Exception {
        List<Contact> contacts = contactDAO.getContacts();
        
        Assert.assertNotNull(contacts);
        Assert.assertTrue(contacts.size() > 0);
    }
    
    @Test
    @Transactional
    public void testAllContactsWithDetail() throws Exception {
        List<Contact> contacts = contactDAO.getContactsWithDetail();
        
        Assert.assertNotNull(contacts);
        Assert.assertTrue(contacts.size() > 0);
    }
    
    @Test
    @Transactional
    public void testGetContacById() throws Exception {
        Contact contact = contactDAO.getContactById(1L);
        
        Assert.assertNotNull(contact);
        Assert.assertNotNull(contact.getFirstName());
        Assert.assertNotNull(contact.getLastName());

    }

	@Test
	@Transactional
	public void testSaveAndGet() throws Exception {
		
	    Contact newContact =  new Contact();
        newContact.setFirstName("NEWfirst");
        newContact.setLastName("newLast");
        newContact.setBirthDate(new Date());
        
        Telephon telephon = new Telephon();
        telephon.setTelNumber("111");
        telephon.setTelType("home");

        newContact.addTelephon(telephon);

        
        contactDAO.save(newContact);
        
        newContact = contactDAO.getContactById(newContact.getId());
        
        Assert.assertEquals(1, newContact.getTelephons().size());
        Assert.assertTrue(newContact.getTelephons().get(0).equals(telephon));

	}
	
	@Test
    @Transactional
    public void testDelete() throws Exception {
        

        Contact contact = contactDAO.getContactById(1L);

        contactDAO.delete(contact);
        
        contact = contactDAO.getContactById(contact.getId());
        Assert.assertNull(contact);



    }



    
    public ContactDAO getContactDAO() {
        return contactDAO;
    }

    public void setContactDAO(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }
}
