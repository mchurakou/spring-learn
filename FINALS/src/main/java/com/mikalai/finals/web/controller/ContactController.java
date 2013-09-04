package com.mikalai.finals.web.controller;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.hibernate.envers.RevisionType;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mikalai.finals.domain.Contact;
import com.mikalai.finals.domain.audit.RevisionEntity;
import com.mikalai.finals.service.ContactService;
import com.mikalai.finals.web.form.AuditContactForm;
import com.mikalai.finals.web.form.ContactGrid;
import com.mikalai.finals.web.form.PageRequest;


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
	
	@RequestMapping(value={"/contacts/{id}", "/contacts/add"},  method = RequestMethod.POST)
	public String saveContact(@Valid Contact contact, BindingResult bindingResult, Model model, HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, Locale locale,
			@RequestParam(value="file", required=false) Part file) {
		logger.info("Save contact");
		
		if (bindingResult.hasErrors()){
			String errorMessage = messageSource.getMessage("error.contact.save", new Object[]{},locale);
			model.addAttribute("message", errorMessage);
			return "contact/show";
		}
		
		model.asMap().clear();
		
		String successMessage = messageSource.getMessage("success.contact.save", new Object[]{},locale);
		redirectAttributes.addFlashAttribute("message", successMessage);
		
		 // Process upload file
        if (file != null) {
			logger.info("File name: " + file.getName());
			logger.info("File size: " + file.getSize());
			logger.info("File content type: " + file.getContentType());
			byte[] fileContent = null;
			try {
				InputStream inputStream = file.getInputStream();
				if (inputStream == null) logger.info("File inputstream is null");
				fileContent = IOUtils.toByteArray(inputStream);
				contact.setPhoto(fileContent);
			} catch (IOException ex) {
				logger.error("Error saving uploaded file");
			}
			contact.setPhoto(fileContent);
		}       
		
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
	
	
	@RequestMapping(value = "/contacts/{id}/delete",  method = RequestMethod.GET)
    public String deleteContact(@PathVariable("id") Long id,Locale locale, Model model) {
        logger.info("User try to delete contact");
        
        contactService.delete(id);

        logger.info("Contact was deleted: " + id);

        return "redirect:/contacts";
    }
	
	@RequestMapping(value = "/contacts/listgrid", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ContactGrid listGrid(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			@RequestParam(value = "sidx", required = false) String sortBy,
			@RequestParam(value = "sord", required = false) String order) {
		
		logger.info("Listing contacts for grid with page: {}, rows: {}", page, rows);
		logger.info("Listing contacts for grid with sort: {}, order: {}", sortBy, order);
		
		
		
		

		PageRequest pageRequest = new PageRequest();
		pageRequest.setPageNumber(page - 1);
		pageRequest.setPageSize(rows);
		if (sortBy != null && order != null) {
			if (order.equals("desc")) {
				pageRequest.setDirection(PageRequest.Direction.DESC);
			} else{
				pageRequest.setDirection(PageRequest.Direction.ASC);
			}
			pageRequest.setSortField(sortBy);
		}
		

				
		ContactGrid contactGrid = contactService.findAllByPage(pageRequest);

		logger.info("Retrived contacts size:" + contactGrid.getContactData().size());
		return contactGrid;
	}
	
	@RequestMapping(value = "/contacts/photo/{id}", method = RequestMethod.GET)
	@ResponseBody
	public byte[] downloadPhoto(@PathVariable("id") Long id) {
		
		Contact contact = contactService.getContactById(id);
        
        if (contact.getPhoto() != null) {
    		logger.info("Downloading photo for id: {} with size: {}", contact.getId(), contact.getPhoto().length);
        }
        
		return contact.getPhoto();
	}
	
	@RequestMapping(value = "/contacts/{id}/log", method = RequestMethod.GET)
	public String showLogForContact(@PathVariable("id") Long id,Locale locale, Model model) {
		logger.info("User entered in show log for contact");
		
		
		List<AuditContactForm> audit = contactService.getAuditContacts(id);
		model.addAttribute("audit",audit);
		
		logger.info("show log view");
		return "contact/audit";
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	
}
