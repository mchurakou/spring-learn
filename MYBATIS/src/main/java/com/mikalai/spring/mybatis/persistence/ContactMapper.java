package com.mikalai.spring.mybatis.persistence;

import java.util.List;

import com.mikalai.spring.mybatis.domain.Contact;

public interface ContactMapper {
    public List<Contact> findAll();
}
