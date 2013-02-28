package com.mikalai.spring.cycle;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class SimpleBean implements BeanNameAware {
    
    private String beanName = "";
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
    
    public void init(){
        System.out.println("Init");
        if (name == null){
            System.out.println("Using def name");
            name = DEFAULT_NAME;
        }
        
        if (age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("Set age for " + SimpleBean.class);
        }
    }
    
    public void destroy(){
        System.out.println("Destroy:" + SimpleBean.class + " " + beanName);
    }
    
    private static SimpleBean getBean(String beanName, ApplicationContext ctx){
        try{
            SimpleBean bean = (SimpleBean) ctx.getBean(beanName);
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
        
        SimpleBean sb1 = getBean("simpleBean1", ctx);
        SimpleBean sb2 = getBean("simpleBean2", ctx);
        //SimpleBean sb3 = getBean("simpleBean3", ctx);
        
        ctx.destroy();

    }
    @Override
    public void setBeanName(String name) {
        beanName = name;
        
    }
}
