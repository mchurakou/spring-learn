package com.mikalai.finals.domain.audit;

import org.hibernate.envers.RevisionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.mikalai.finals.dao.UserDAO;
import com.mikalai.finals.domain.User;

public class AuditHandler implements RevisionListener {

	@Autowired
    private UserDAO userDAO;
	
    public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
    public void newRevision(Object revision) {
        RevisionEntity revisionEntity = (RevisionEntity) revision;
        
        
        if (SecurityContextHolder.getContext().getAuthentication() != null){
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal != null){
                UserDetails userDetails = null;
                if (principal instanceof UserDetails) {
                  userDetails = (UserDetails) principal;
                }

                revisionEntity.setUserName(userDetails.getUsername());
            }
        }
    }

}
