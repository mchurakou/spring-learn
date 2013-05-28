package com.mikalai.spring.mybatis.domain;

import java.io.Serializable;

public class ContactTelDetail implements Serializable {

    private Long id;
    private String telType;
    private String telNumber;
    private Contact contact;
    public Long getId() {
        return id;
    }
    @Override
    public String toString() {
        return "ContactTelDetail [id=" + id + ", telType=" + telType
                + ", telNumber=" + telNumber + ", ]";
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTelType() {
        return telType;
    }
    public void setTelType(String telType) {
        this.telType = telType;
    }
    public String getTelNumber() {
        return telNumber;
    }
    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
    public Contact getContact() {
        return contact;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
