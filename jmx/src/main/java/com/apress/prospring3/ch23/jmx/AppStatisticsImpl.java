
package com.apress.prospring3.ch23.jmx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;

import com.apress.prospring3.ch23.jmx.AppStatistics;
import com.apress.prospring3.ch23.service.ContactService;


public class AppStatisticsImpl implements AppStatistics {

	@Autowired
	private ContactService contactService;	
	
	@Autowired
	private SessionRegistry sessionRegistry;
	
	public int getTotalContactCount() {
		return contactService.findAll().size();
	}
	
	public int getLoggedInUserCount() {
		return sessionRegistry.getAllPrincipals().size();
	}	
	
	public List<Object> getLoggedInUsers() {
		return sessionRegistry.getAllPrincipals();
	}

}
