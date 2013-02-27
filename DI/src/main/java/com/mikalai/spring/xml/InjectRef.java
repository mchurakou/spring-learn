package com.mikalai.spring.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mikalai.spring.Oracle;

public class InjectRef {
    private Oracle oracle; 
    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-xml.xml");
        ctx.refresh();
        
        InjectRef i = ctx.getBean("injectRef", InjectRef.class);
        System.out.println(i.oracle.defineMeaningOfLife());

    }
    public Oracle getOracle() {
        return oracle;
    }
    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
    }

}
