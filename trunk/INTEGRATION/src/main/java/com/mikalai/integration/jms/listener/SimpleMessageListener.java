
package com.mikalai.integration.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SimpleMessageListener implements MessageListener {

	private static final Logger logger = LoggerFactory.getLogger(SimpleMessageListener.class);
	
	public void onMessage(Message message) {

		TextMessage textMessage = (TextMessage) message;
		
		try {
			logger.info("Message received: " + textMessage.getText());
		} catch (JMSException ex) {
			logger.error("JMS error", ex);
		}
		
	}	
	
}
