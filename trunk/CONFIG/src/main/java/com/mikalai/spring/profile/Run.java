package com.mikalai.spring.profile;

import java.util.List;
import java.util.Locale;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Run {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("school");
        ctx.load("classpath:*.xml");
        ctx.refresh();
        
        FoodProviderService service = (FoodProviderService)ctx.getBean("foodProviderService");
        
        List<Food> lunch = service.provideLunchSet();
        
        for(Food food : lunch){
            System.out.println(food.getName());
        }
        


    }
}
