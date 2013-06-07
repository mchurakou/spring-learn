
package com.mikalai.spring.converter;

import org.springframework.core.convert.converter.Converter;

import com.mikalai.spring.domain.AnotherContact;
import com.mikalai.spring.domain.Contact;



public class ContactToAnotherContactConverter implements Converter<Contact, AnotherContact> {
	
	public AnotherContact convert(Contact contact) {
		AnotherContact anotherContact = new AnotherContact();
		anotherContact.setFirstName(contact.getLastName());
		anotherContact.setLastName(contact.getFirstName());
		anotherContact.setBirthDate(contact.getBirthDate());
		anotherContact.setPersonalSite(contact.getPersonalSite());
		
		return anotherContact;
	}

}
