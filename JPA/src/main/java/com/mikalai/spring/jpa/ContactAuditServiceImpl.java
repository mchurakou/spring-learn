package com.mikalai.spring.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.mikalai.spring.domain.ContactAudit;
import com.mikalai.spring.jpa.repository.ContactAuditRepository;

@Service("contactAuditService")
@Repository
@Transactional
public class ContactAuditServiceImpl implements ContactAuditService {
    
    @Autowired
    private ContactAuditRepository contactAuditRepository;
    
    @Transactional(readOnly=true)
    public List<ContactAudit> findAll() {
        return Lists.newArrayList(contactAuditRepository.findAll());
    }

    @Override
    public ContactAudit findById(Long id) {
        return contactAuditRepository.findOne(id);

    }

    @Override
    public ContactAudit save(ContactAudit contact) {
        return contactAuditRepository.save(contact);
    }

    @Override
    public ContactAudit findAuditByRevision(Long id, int revision) {
        // TODO Auto-generated method stub
        return null;
    }



}
