
package com.mikalai.spring.inheritance;

import org.springframework.context.support.GenericXmlApplicationContext;


public class SimpleBean {

    public String name;

    public int age;
    
    public static void main(String[] args) {
    	
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    	ctx.load("classpath:app-context-xml.xml");
        
        SimpleBean parent = (SimpleBean) ctx.getBean("inheritParent");
        SimpleBean child = (SimpleBean) ctx.getBean("inheritChild");
        
        System.out.println("Parent:\n" + parent);
        System.out.println("Child:\n" + child);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
        
    public String toString() {
        return    "Name: " + name + "\n"
                + "Age: " + age;
    }
}