
package com.mikalai.spring.validation.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikalai.spring.domain.Customer;



@Service("myBeanValidationService")
public class MyBeanValidationService {

	@Autowired
	private Validator validator;
	
	public Set<ConstraintViolation<Customer>> validateCustomer(Customer customer) {
		return validator.validate(customer);
	}
}
