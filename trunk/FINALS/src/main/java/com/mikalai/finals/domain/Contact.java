package com.mikalai.finals.domain;

import java.io.Serializable;


import java.util.Date;




public class Contact implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int version;


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
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

}
