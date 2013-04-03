package com.mikalai.spring.aspect.proxyfactorybean;

import org.springframework.context.support.GenericXmlApplicationContext;


public class Run {

    /**
     * @param args
     */

        public static void main(String[] args) {
            GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
            ctx.load("classpath:aop.xml");
            ctx.refresh();      

            MyBean mb = (MyBean) ctx.getBean("myBean");

            mb.execute();
           

        }


}
