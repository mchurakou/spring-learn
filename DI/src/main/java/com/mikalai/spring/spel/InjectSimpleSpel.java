package com.mikalai.spring.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("injectSimpleSpel")
public class InjectSimpleSpel {
    
    @Value("#{injectSimpleConfig.name}")
    private String name;
    
    @Value("#{injectSimpleConfig.age + 2}")
    private int age;
    
    @Value("#{injectSimpleConfig.height}")
    private float height;
    
    
    @Value("#{injectSimpleConfig.programmer}")
    private boolean programmer;
    
    @Value("#{injectSimpleConfig.ageInSeconds}")
    private Long ageInSeconds;
    
    
    @Override
    public String toString() {
        return "InjectSimpleSpel [name=" + name + ", age=" + age + ", height="
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
}
