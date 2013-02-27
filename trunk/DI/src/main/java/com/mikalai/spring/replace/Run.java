package com.mikalai.spring.replace;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;


public class Run {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:replacement.xml");
        ctx.refresh();
        
        ReplacementTarget r = ctx.getBean("replacementTarget", ReplacementTarget.class);
        ReplacementTarget s = ctx.getBean("standardTarget", ReplacementTarget.class);
  
        displayInfo(s);
        displayInfo(r);


    }
    
    public static void displayInfo(ReplacementTarget bean){
        System.out.println(bean.formatMessage("Hello"));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("replace demo");
        
        for (int x = 0; x < 10000; x++){
            String out = bean.formatMessage("foo");
        }
        
        stopWatch.stop();
        
        System.out.println("time:" + stopWatch.getTotalTimeMillis());
        
        
        
    }
}
