package com.mikalai.finals.domain;


import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

