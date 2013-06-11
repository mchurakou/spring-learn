/**
 * Created on Nov 25, 2011
 */
package com.mikalai.integration.jms;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mikalai.integration.jms.sender.MessageSender;



/**
 * @author Clarence
 *
 */
public class JmsSenderSample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:jms-sender-app-context.xml");
		ctx.refresh();
		
		// Send message
		MessageSender messageSender = ctx.getBean("messageSender", MessageSender.class);

		messageSender.sendMessage("MIKALAI testing JMS message");
	}

}
