package com.mikalai.spring.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.mikalai.spring.domain.ContactAudit;

public interface ContactAuditRepository extends CrudRepository<ContactAudit, Long> {

}
