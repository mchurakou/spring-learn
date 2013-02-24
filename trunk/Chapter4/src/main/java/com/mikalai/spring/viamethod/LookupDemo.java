package com.mikalai.spring.viamethod;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

import com.mikalai.spring.hierarchical.SimpleTarget;

public class LookupDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:lookup.xml");
        ctx.refresh();
        
        DemoBean abstractBean = ctx.getBean("abstractBean", DemoBean.class);
        DemoBean standardBean = ctx.getBean("standardBean", DemoBean.class);
  
        displayInfo(standardBean);
        displayInfo(abstractBean);


    }
    
    public static void displayInfo(DemoBean bean){
        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();
        System.out.println("eq:" + (helper1 == helper2));
        
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookup demo");
        
        for (int x = 0; x < 100; x++){
            MyHelper helper = bean.getMyHelper(); 
            helper.doing();
        }
        
        stopWatch.stop();
        
        System.out.println("time:" + stopWatch.getTotalTimeMillis());
        
        
        
    }

}
