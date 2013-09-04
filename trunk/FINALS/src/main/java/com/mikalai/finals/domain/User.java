package com.mikalai.finals.domain;

import java.util.ArrayList;

import java.util.List;



import javax.persistence.Embedded;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;


import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;




@Entity
@Table( name = "USERS" )
public class User {
    
    
    
    private Long id;
    
    
    private Credential credential;
    
   
    private List<Role> roles = new ArrayList<Role>();
    



   
   



    public User(String login, String password){
        this.credential = new Credential(login, password);
    }
    
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
   
    @Embedded
    public Credential getCredential() {
        return credential;
    }


    public void setCredential(Credential credential) {
        this.credential = credential;
    }


    public User(){
        
    }

    
    @ManyToMany
    @JoinTable(name = "ROLES_USERS", joinColumns =  @JoinColumn(name = "USER_ID"), inverseJoinColumns =  @JoinColumn(name = "ROLE_ID") )
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Role> getRoles() {
        return roles;
    }


    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    


}
