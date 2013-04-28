package com.mikalai.dao.jdbc.bean;

import java.io.Serializable;

public class ContactTelDetail implements Serializable {
    private Long id;
    private Long contactId;
    @Override
    public String toString() {
        return "ContactTelDetail [id=" + id + ", contactId=" + contactId
                + ", telType=" + telType + ", telNumnber=" + telNumber + "]";
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getContactId() {
        return contactId;
    }
    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }
    public String getTelType() {
        return telType;
    }
    public void setTelType(String telType) {
        this.telType = telType;
    }
    public String getTelNumnber() {
        return telNumber;
    }
    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
    private String telType;
    private String telNumber;
}
