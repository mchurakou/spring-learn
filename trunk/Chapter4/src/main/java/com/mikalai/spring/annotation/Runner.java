package com.mikalai.spring.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mikalai.spring.xml.MessageProvider;

public class Runner {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();
        
        MessageProvider messageProvider = ctx.getBean("messageProvider", MessageProvider.class);
        System.out.println(messageProvider.getMessage());
    }

}
