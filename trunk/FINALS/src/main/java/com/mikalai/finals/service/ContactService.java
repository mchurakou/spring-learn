package com.mikalai.finals.service;

import java.util.List;




import com.mikalai.finals.domain.Contact;
import com.mikalai.finals.domain.Hobby;
import com.mikalai.finals.web.form.ContactGrid;
import com.mikalai.finals.web.form.PageRequest;





public interface ContactService {
    public List<Hobby> getHobbies();
    public List<Contact> getContacts();
    public List<Contact> getContactsWithDetail();
    public Contact getContactById(Long id);
    public Contact save(Contact contact);
    public void delete(Long id);
    
    public List<Object []> getAuditContacts(Long id);
    
	public ContactGrid findAllByPage(PageRequest pageRequest);
    

}
