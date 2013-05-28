package com.mikalai.spring.mybatis.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Contact implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Set<ContactTelDetail> contactTelDetails = new HashSet<ContactTelDetail>();;
  
    private Set<Hobby> hobbies = new HashSet<Hobby>();
    
    @Override
    public String toString() {
        return "Contact [id=" + id + ", firstName=" + firstName + ", lastName="
                + lastName + ", birthDate=" + birthDate
                + ", contactTelDetails=" + contactTelDetails + ", hobbies="
                + hobbies + "]";
    }
    
    public Set<Hobby> getHobbies() {
        return hobbies;
    }
    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }
    public Set<ContactTelDetail> getContactTelDetails() {
        return contactTelDetails;
    }
    public void setContactTelDetails(Set<ContactTelDetail> contactTelDetails) {
        this.contactTelDetails = contactTelDetails;
    }
   
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
