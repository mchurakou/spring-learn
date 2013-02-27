package com.mikalai.spring.xml;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service("injectSimple")
public class InjectSimple {
    
    @Value("Petr")
    private String name;
    
    @Value("35")
    private int age;
    
    @Value("1.78")
    private float height;
    
    @Value("true")
    private boolean programmer;
    
    @Value("1111111")
    private Long ageInSeconds;
    @Override
    public String toString() {
        return "InjectSimple [name=" + name + ", age=" + age + ", height="
                + height + ", programmer=" + programmer + ", ageInSeconds="
                + ageInSeconds + "]";
    }
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
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public boolean isProgrammer() {
        return programmer;
    }
    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }
    public Long getAgeInSeconds() {
        return ageInSeconds;
    }
    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();
        
        InjectSimple simple = (InjectSimple) ctx.getBean("injectSimple");
        System.out.println(simple);


    }

}
