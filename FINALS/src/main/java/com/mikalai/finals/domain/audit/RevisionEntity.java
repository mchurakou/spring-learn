package com.mikalai.finals.domain.audit;

import javax.persistence.Entity;

import org.hibernate.envers.DefaultRevisionEntity;



@Entity
@org.hibernate.envers.RevisionEntity(AuditHandler.class)
public class RevisionEntity extends DefaultRevisionEntity {
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
}
