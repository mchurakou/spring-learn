package com.mikalai.spring.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;
import com.mikalai.spring.xml.MessageRenderer;

public class Runner {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();

        MessageRenderer messageRenderer = ctx.getBean("messageRenderer", MessageRenderer.class);
        messageRenderer.render();

    }

}
