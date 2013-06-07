
package com.mikalai.spring.validation.classvalidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mikalai.spring.domain.Contact;



@Component("contactValidator")
public class ContactValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Contact.class.equals(clazz);
	}

	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "firstName", "firstName.empty");
	}

}
