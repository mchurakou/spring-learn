package com.mikalai.spring.env;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import com.mikalai.spring.profile.Food;
import com.mikalai.spring.profile.FoodProviderService;

public class AppProperty {
    private String applicationHome;
    private String userHome;
    
    public String getApplicationHome() {
        return applicationHome;
    }
    public void setApplicationHome(String applicationHome) {
        this.applicationHome = applicationHome;
    }
    public String getUserHome() {
        return userHome;
    }
    public void setUserHome(String userHome) {
        this.userHome = userHome;
    }
    
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:env.xml");
        ctx.refresh();
        
        AppProperty prop = (AppProperty)ctx.getBean("appProperty");
        System.out.println(prop);

        


    }
    @Override
    public String toString() {
        return "AppProperty [applicationHome=" + applicationHome
                + ", userHome=" + userHome + "]";
    }
}
