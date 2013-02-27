package com.mikalai.spring.hierarchical;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mikalai.spring.xml.MessageRenderer;

public class HierarhicalAppContextUsage {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
        parent.load("classpath:parent.xml");
        parent.refresh();
        
        GenericXmlApplicationContext child = new GenericXmlApplicationContext();
        child.load("app-context-xml.xml");
        child.setParent(parent);
        child.refresh();
        

        SimpleTarget target1 = child.getBean("target1", SimpleTarget.class);
        SimpleTarget target2 = child.getBean("target2", SimpleTarget.class);
        SimpleTarget target3 = child.getBean("target3", SimpleTarget.class);
       
        System.out.println(target1.getVal());
        System.out.println(target2.getVal());
        System.out.println(target3.getVal());

    }

}
