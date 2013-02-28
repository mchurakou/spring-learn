package com.mikalai.spring.cycle;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanWithInterface implements InitializingBean, DisposableBean {
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
    

    
    private static SimpleBeanWithInterface getBean(String beanName, ApplicationContext ctx){
        try{
            SimpleBeanWithInterface bean = (SimpleBeanWithInterface) ctx.getBean(beanName);
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
        ctx.refresh();
        
        SimpleBeanWithInterface sb1 = getBean("simpleBeanWintInterface1", ctx);
        SimpleBeanWithInterface sb2 = getBean("simpleBeanWintInterface2", ctx);
        //SimpleBeanWithInterface sb3 = getBean("simpleBeanWintInterface3", ctx);
        
        ctx.destroy();

    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Init");
        if (name == null){
            System.out.println("Using def name");
            name = DEFAULT_NAME;
        }
        
        if (age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("Set age for " + SimpleBeanWithInterface.class);
        }

    }
    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy:" + SimpleBeanWithInterface.class);
        
    }
    


}
