
package com.mikalai.spring.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mikalai.spring.domain.Customer;



public class IndividualCustomerValidator implements ConstraintValidator<CheckIndividualCustomer, Customer> {

	public void initialize(CheckIndividualCustomer constraintAnnotation) {
	}

	public boolean isValid(Customer customer, ConstraintValidatorContext context) {

		boolean result = true;
		
		if (customer.getCustomerType() != null && 
				(customer.isIndividualCustomer()
				&& (customer.getLastName() == null || customer.getGender() == null))
			) {
			result = false;
		}
		
		return result;
	}	
	
}
