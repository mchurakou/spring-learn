package com.mikalai.spring.mybatis.persistence;

import java.util.List;

import com.mikalai.spring.mybatis.domain.Contact;
import com.mikalai.spring.mybatis.domain.SearchCriteria;

public interface ContactMapper {
    public List<Contact> findAll();
    public List<Contact> findAllWithDetail();
    public Contact findById(Long id);
    
    public List<Contact> findByFirstNameAndLastName(SearchCriteria sc);
}
