package com.mikalai.spring;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.convert.ConversionService;

import com.mikalai.spring.domain.AnotherContact;
import com.mikalai.spring.domain.Contact;
import com.mikalai.spring.domain.CustomerType;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        //ctx.load("classpath:prop-editor-app-context.xml");
		//ctx.load("classpath:conv-service-app-context.xml");
		ctx.load("classpath:conv-format-service-app-context.xml");
        ctx.refresh();
        
        ConversionService cs = ctx.getBean(ConversionService.class);
        
        Contact clarence = ctx.getBean("clarence", Contact.class);
        System.out.println(clarence);
        
        cs.convert(clarence.getBirthDate(), String.class);
        
        
        
        /*AnotherContact ac = cs.convert(clarence, AnotherContact.class);
        
        System.out.println(ac);*/
        
      /*  Contact my = ctx.getBean("myContact", Contact.class);
        System.out.println(my);*/

	}

}
