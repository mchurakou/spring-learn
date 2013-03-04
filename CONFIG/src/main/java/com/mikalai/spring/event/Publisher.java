package com.mikalai.spring.event;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Publisher implements ApplicationContextAware {
    private ApplicationContext ctx;
    public ApplicationContext getCtx() {
        return ctx;
    }
    public void setCtx(ApplicationContext ctx) {
        this.ctx = ctx;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.ctx = applicationContext;

    }
    
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:event.xml");
        ctx.refresh();
        
        Publisher p = ctx.getBean("publisher", Publisher.class);
        p.publish("Hello");
        p.publish("buy");
        
 

    }
    
    public void publish(String msg){
        ctx.publishEvent(new MessageEvent(this, msg));
    }

}
