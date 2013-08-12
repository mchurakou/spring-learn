package com.mikalai.finals.domain;



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
@Table(name="TELEPHON")
public class Telephon implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    
    private Long id;
    private String telType;
    private String telNumber;
    private int version;
    
    private Contact contact;
    
    
    @ManyToOne
    @JoinColumn(name="CONTACT_ID")
    public Contact getContact() {
        return contact;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="ID")
    public Long getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Telephon [id=" + id + ", telType=" + telType + ", telNumber="
                + telNumber + ", version=" + version + "]";
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="TEL_TYPE")
    public String getTelType() {
        return telType;
    }
    public void setTelType(String telType) {
        this.telType = telType;
    }
    
    @Column(name="TEL_NUMBER")
    public String getTelNumber() {
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
    
    
    
}
