package com.mikalai.spring.domain;

import java.io.Serializable;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import org.springframework.data.domain.Auditable;

import static javax.persistence.GenerationType.IDENTITY;



@Entity
@Table(name="contact_audit")

public class ContactAudit implements Auditable<String, Long> {
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int version;
    
        
 // Audit fields
    private String createdBy;
    private DateTime createdDate;   
    private String lastModifiedBy;
    private DateTime lastModifiedDate;
    


    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name="BIRTH_DATE")
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date date) {
        this.birthDate = date;
    }
    
    
    @Version
    @Column(name="VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    
    
    @Column(name="CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    @Column(name="CREATED_DATE")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }
    
    @Column(name="LAST_MODIFIED_BY")
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
    
    @Column(name="LAST_MODIFIED_DATE")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }
    public void setLastModifiedDate(DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    
    @Override
    public String toString() {
        return "ContactAudit [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", birthDate=" + birthDate
                + ", version=" + version + ", createdBy=" + createdBy
                + ", createdDate=" + createdDate + ", lastModifiedBy="
                + lastModifiedBy + ", lastModifiedDate=" + lastModifiedDate
                + "]";
    }

    @Transient
    public boolean isNew() {
        if (id == null){
            return true;
        } else {
            return false;
        }
    }
    



}
