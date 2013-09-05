package com.mikalai.finals.domain.audit;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.DefaultRevisionEntity;

import com.mikalai.finals.domain.User;



@Entity
@Table( name = "REVISION_ENTITY" )
@org.hibernate.envers.RevisionEntity(AuditHandler.class)
public class RevisionEntity extends DefaultRevisionEntity {
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;


}
