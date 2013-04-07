package com.mikalai.spring.aspect.integration;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mikalai.spring.aspect.aspectj.MyBean;

public class Run {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:aspectj.xml");
        ctx.refresh();
        
        MessageWriter mw = new MessageWriter();
        mw.writeMessage();
        mw.foo();
    }

}
