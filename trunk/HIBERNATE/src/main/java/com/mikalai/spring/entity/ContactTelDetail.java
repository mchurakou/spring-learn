package com.mikalai.spring.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;



@Entity
@Table(name="contact_tel_detail")
public class ContactTelDetail implements Serializable {
    private Long id;
    private Long contactId;
    private String telType;
    private String telNumber;
    private int version;
    
    private Contact contact;
    




    public ContactTelDetail(){
        
    }
    
    
    
    public ContactTelDetail(String telType, String telNumber) {
        super();
        this.telType = telType;
        this.telNumber = telNumber;
    }



    @Override
    public String toString() {
        return "ContactTelDetail [id=" + id + ", contactId=" + contactId
                + ", telType=" + telType + ", telNumnber=" + telNumber + "]";
    }
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="ID")
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
    
    @Column(name="TEL_TYPE")
    public String getTelType() {
        return telType;
    }
    public void setTelType(String telType) {
        this.telType = telType;
    }
    
    @Column(name="TEL_NUMBER")
    public String getTelNumnber() {
        return telNumber;
    }
    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
    
    
    @Version
    @Column(name="VERSION")
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    public String getTelNumber() {
        return telNumber;
    }
    
    
    @ManyToOne
    @JoinColumn(name="CONTACT_ID")
    public Contact getContact() {
        return contact;
    }



    public void setContact(Contact contact) {
        this.contact = contact;
    }
    
}
