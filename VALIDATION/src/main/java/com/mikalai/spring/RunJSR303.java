package com.mikalai.spring;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.validation.Validator;

import com.mikalai.spring.domain.Customer;
import com.mikalai.spring.domain.CustomerType;
import com.mikalai.spring.validation.service.MyBeanValidationService;

public class RunJSR303 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:jsr303-app-context.xml");
        ctx.refresh();
        MyBeanValidationService mbvs = ctx.getBean("myBeanValidationService", MyBeanValidationService.class);
        
        Customer c = new Customer();
        c.setFirstName("C");
        c.setLastName("Ho");
        c.setCustomerType(CustomerType.INDIVIDUAL);
        c.setGender(null);
        
        Set<ConstraintViolation<Customer>> errors = mbvs.validateCustomer(c);
        
        for (ConstraintViolation<Customer> v : errors) {
        	System.out.println(v.getPropertyPath() + " | " + v.getInvalidValue() + " | " + v.getMessage());
        }


	}

}
