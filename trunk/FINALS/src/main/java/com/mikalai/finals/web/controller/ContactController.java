package com.mikalai.finals.web.controller;


import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@Autowired
	private MessageSource messageSource;

	

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
	
	@RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
	public String showContact(@PathVariable("id") Long id,Locale locale, Model model) {
		logger.info("User entered in show contact page");
		
		Contact contact = contactService.getContactById(id);
		
		model.addAttribute("contact", contact );
		logger.info("Contact for showing: " + contact);
		
		logger.info("show contact view");
		return "contact/show";
	}
	
	@RequestMapping(value = "/contacts/{id}",  method = RequestMethod.POST)
	public String saveContact(Contact contact, BindingResult bindingResult, Model model, HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, Locale locale) {
		logger.info("Save contact");
		
		if (bindingResult.hasErrors()){
			String errorMessage = messageSource.getMessage("error.contact.save", new Object[]{},locale);
			model.addAttribute("message", errorMessage);
			return "contact/show";
		}
		
		model.asMap().clear();
		
		String successMessage = messageSource.getMessage("success.contact.save", new Object[]{},locale);
		redirectAttributes.addFlashAttribute("message", successMessage);
		contactService.save(contact);
		
		logger.info("Contact was saved: " + contact);

		return "redirect:/contacts/" + contact.getId();
	}
	
	@RequestMapping(value = "/contacts/add", method = RequestMethod.GET)
	public String showNewContactForm(Locale locale, Model model) {
		logger.info("User entered in new contact contact page");
		
		Contact contact = new Contact();
		model.addAttribute("contact", contact );

		return "contact/show";
	}
	
	@RequestMapping(value = "/contacts/add",  method = RequestMethod.POST)
	public String addContact(Contact contact, BindingResult bindingResult, Model model, HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, Locale locale) {
		logger.info("Add contact");
		
		if (bindingResult.hasErrors()){
			String errorMessage = messageSource.getMessage("error.contact.save", new Object[]{},locale);
			model.addAttribute("message", errorMessage);
			return "contact/add";
		}
		
		model.asMap().clear();
		
		String successMessage = messageSource.getMessage("success.contact.save", new Object[]{},locale);
		redirectAttributes.addFlashAttribute("message", successMessage);
		contactService.save(contact);
		
		logger.info("Contact was added: " + contact);

		return "redirect:/contacts/" + contact.getId();
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	
}
