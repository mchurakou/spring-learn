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

public class Run {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.refresh();
        ConfigurableEnvironment env = ctx.getEnvironment();
        MutablePropertySources mps = env.getPropertySources();
        
        Map appMap = new HashMap();
        appMap.put("application.home", "/etc/prospring3/home");
        mps.addLast(new MapPropertySource("PROSPRING3_MAP",appMap));
        
        System.out.println("user.home=" + System.getProperty("user.home"));
        System.out.println("JAVA_HOME=" + System.getenv("JAVA_HOME"));
        
        System.out.println("user.home=" + env.getProperty("user.home"));
        System.out.println("JAVA_HOME=" + env.getProperty("JAVA_HOME"));
        System.out.println("application.home=" + env.getProperty("application.home"));
        
       
        }
        



}
