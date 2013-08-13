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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((telNumber == null) ? 0 : telNumber.hashCode());
        result = prime * result + ((telType == null) ? 0 : telType.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Telephon other = (Telephon) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (telNumber == null) {
            if (other.telNumber != null)
                return false;
        } else if (!telNumber.equals(other.telNumber))
            return false;
        if (telType == null) {
            if (other.telType != null)
                return false;
        } else if (!telType.equals(other.telType))
            return false;
        return true;
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
