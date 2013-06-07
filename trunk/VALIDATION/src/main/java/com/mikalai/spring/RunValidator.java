package com.mikalai.spring;


import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mikalai.spring.domain.Contact;

public class RunValidator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring-validator-app-context.xml");
        ctx.refresh();
        
        Validator contactValidator = ctx.getBean("contactValidator", Validator.class);
        
        Contact c = new Contact();
        c.setFirstName(null);
        c.setLastName("l");
        
        BeanPropertyBindingResult res = new BeanPropertyBindingResult(c, "Clarence");
        
        ValidationUtils.invokeValidator(contactValidator, c, res);
        List<ObjectError> errors= res.getAllErrors();
        for (ObjectError e : errors){
        	System.out.println(e.getCode());
        }
        


	}

}
