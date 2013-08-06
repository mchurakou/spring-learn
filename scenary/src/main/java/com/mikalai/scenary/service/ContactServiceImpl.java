
package com.mikalai.scenary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.mikalai.scenary.domain.Contact;
import com.mikalai.scenary.rule.domain.Rule;
import com.mikalai.scenary.rule.engine.RuleEngine;
import com.mikalai.scenary.rule.factory.RuleFactory;
import com.mikalai.scenary.service.ContactService;


@Service("contactService")
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	ApplicationContext ctx;

	@Autowired
	private RuleFactory ruleFactory;
	
	@Autowired
	private RuleEngine ruleEngine;
	
	public void applyRule(Contact contact) {

		// Apply ageCategory rule
		ruleFactory = ctx.getBean("ruleFactory", RuleFactory.class);
		Rule ageCategoryRule = ruleFactory.getAgeCategoryRule();
		ruleEngine.run(ageCategoryRule, contact);
		
	}	
	
}
