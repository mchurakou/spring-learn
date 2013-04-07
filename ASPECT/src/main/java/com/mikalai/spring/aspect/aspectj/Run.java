package com.mikalai.spring.aspect.aspectj;

import org.springframework.context.support.GenericXmlApplicationContext;



public class Run {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:aspectj.xml");
        ctx.refresh();
        
        MyBean myBean = (MyBean) ctx.getBean("myBean");

        myBean.execute();
    }

}
