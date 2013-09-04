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
import com.mikalai.finals.web.form.AuditContactForm;



@ContextConfiguration(locations={"classpath:/spring/app-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("h2")
public class ContactDAOTest {

	@Autowired
	private ContactDAO contactDAO;



    @Test
	
	public void testAllHobbiess() throws Exception {
	    List<Hobby> hobbies = contactDAO.getHobbies();
		
		Assert.assertNotNull(hobbies);
		Assert.assertTrue(hobbies.size() > 0);
	}
    
 
    
	@Test
	
	public void testSaveAndGet() throws Exception {
		
	    Contact newContact =  new Contact();
        newContact.setFirstName("TEST");
        newContact.setLastName("TEST");
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
    public void testDelete() throws Exception {
        
	    Contact newContact =  new Contact();
        newContact.setFirstName("TEST_DELETE");
        newContact.setLastName("TEST_DELETE");
        newContact.setBirthDate(new Date());
        contactDAO.save(newContact);

        Long id =  newContact.getId();
        contactDAO.delete(newContact.getId());
        
        newContact = contactDAO.getContactById(newContact.getId());
        Assert.assertNull(newContact);
        
        List<AuditContactForm> audit = contactDAO.getAuditContacts(id);
        
        Assert.assertTrue(audit.size() > 0);


    }



    
    public ContactDAO getContactDAO() {
        return contactDAO;
    }

    public void setContactDAO(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }
}
