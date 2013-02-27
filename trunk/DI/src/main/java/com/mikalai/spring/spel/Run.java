package com.mikalai.spring.spel;

import org.springframework.context.support.GenericXmlApplicationContext;


public class Run {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();
        
        InjectSimpleSpel i = ctx.getBean("injectSimpleSpel", InjectSimpleSpel.class);
        System.out.println(i);

    }

}
