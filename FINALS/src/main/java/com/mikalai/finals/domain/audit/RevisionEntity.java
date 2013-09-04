package com.mikalai.finals.domain.audit;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.envers.DefaultRevisionEntity;

import com.mikalai.finals.domain.User;



@Entity
@org.hibernate.envers.RevisionEntity(AuditHandler.class)
public class RevisionEntity extends DefaultRevisionEntity {
    private User user;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
