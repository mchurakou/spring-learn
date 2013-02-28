package com.mikalai.spring.cycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanWithJSR250 {
    private static final String DEFAULT_NAME = "Luke Skywalker";
    private String name = null;
    private int age = Integer.MIN_VALUE;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    

    
    private static SimpleBeanWithJSR250 getBean(String beanName, ApplicationContext ctx){
        try{
            SimpleBeanWithJSR250 bean = (SimpleBeanWithJSR250) ctx.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException e){
            System.out.println("Error" + e.getMessage());
            return null;
        }
        
    }
    
    @Override
    public String toString() {
        return "SimpleBean [name=" + name + ", age=" + age + "]";
    }
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context.xml");
        ctx.registerShutdownHook();
        ctx.refresh();
        
        SimpleBeanWithJSR250 sb1 = getBean("simpleBeanWithJSR2501", ctx);
        SimpleBeanWithJSR250 sb2 = getBean("simpleBeanWithJSR2502", ctx);
        //SimpleBeanWithJSR250 sb3 = getBean("simpleBeanWithJSR2503", ctx);
        
        //ctx.destroy();

    }
    
    @PostConstruct
    public void init() throws Exception {
        System.out.println("Init");
        if (name == null){
            System.out.println("Using def name");
            name = DEFAULT_NAME;
        }
        
        if (age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("Set age for " + SimpleBeanWithJSR250.class);
        }

    }
    
    @PreDestroy
    public void destroy(){
        System.out.println("DESTROY:" + SimpleBeanWithJSR250.class);
    }
}
