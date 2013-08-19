package com.mikalai.finals.domain;


import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;




@Entity

@Table(name = "HOBBY")
public class Hobby implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    private Long id;
    private String name;
    private int version;
    private Set<Contact> contacts = new HashSet<Contact>();
    
    @ManyToMany
    @JoinTable(name="CONTACT_HOBBY", joinColumns = @JoinColumn(name="HOBBY_ID"),    inverseJoinColumns = @JoinColumn(name="CONTACT_ID"))
    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    
    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Version
    @Column(name="VERSION")
    public int getVersion() {
        return version;
    }
    
    
    @Override
    public String toString() {
        return "Hobby [id=" + id + ", name=" + name + ", version=" + version
                + "]";
    }

    public void setVersion(int version) {
        this.version = version;
    }
    

}

