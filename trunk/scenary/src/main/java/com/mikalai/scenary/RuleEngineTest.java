
package com.mikalai.scenary;

import org.joda.time.format.DateTimeFormat;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.mikalai.scenary.domain.Contact;
import com.mikalai.scenary.service.ContactService;


public class RuleEngineTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
		
		ContactService contactService = ctx.getBean("contactService", ContactService.class);
		
		// Construct Contact object
		Contact contact = new Contact();
		contact.setId(1l);
		contact.setFirstName("Clarence");
		contact.setLastName("Ho");
		contact.setBirthDate(DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime("1980-08-09"));

		// Apply rule to contact object
		contactService.applyRule(contact);
		System.out.println("Contact: " + contact);
		
		// Wait for rule to be updated
		try {
			System.in.read();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		// Apply the rule again
		contactService.applyRule(contact);	
		System.out.println("Contact: " + contact);		
		
	}

}
