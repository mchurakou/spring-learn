package com.mikalai.spring.jpa;

import java.util.List;

import com.mikalai.spring.domain.ContactAudit;

public interface ContactAuditService {
    public List<ContactAudit> findAll();
    
    public ContactAudit findById(Long id);
    
    public ContactAudit save(ContactAudit contact); 
    
    public ContactAudit findAuditByRevision(Long id, int revision);
}
