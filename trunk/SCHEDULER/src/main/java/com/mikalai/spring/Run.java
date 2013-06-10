package com.mikalai.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:task-namespace-app-context.xml");
        ctx.refresh();

        while (true){
        	
        }

	}

}
