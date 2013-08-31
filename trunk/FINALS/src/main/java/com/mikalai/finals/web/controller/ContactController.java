package com.mikalai.finals.web.controller;


import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mikalai.finals.domain.Contact;
import com.mikalai.finals.service.ContactService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ContactController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String enter(Locale locale, Model model) {
        logger.info("Forward to contact list");
        return "redirect:contacts";
    }
	
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public String contactList(Locale locale, Model model) {
		logger.info("User entered in contact list page");
		
		List<Contact> contacts = contactService.getContacts();
		
		model.addAttribute("contacts", contacts );
		logger.info("Contacts for showing: " + contacts.size());
		
		logger.info("show contactList view");
		return "contact/list";
	}
	
}
