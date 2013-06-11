
package com.mikalai.integration.jms;

import org.springframework.context.support.GenericXmlApplicationContext;


public class JmsListenerSample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:jms-listener-app-context.xml");
		ctx.refresh();
		
		while (true) {
		}

	}

}
