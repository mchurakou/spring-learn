package com.mikalai.spring.xml;

import org.springframework.stereotype.Service;




@Service("messageProvider")
public class HelloWordMessageProvider implements MessageProvider {
	

	public String getMessage() {
		return "Hello world!";	
	}

}
