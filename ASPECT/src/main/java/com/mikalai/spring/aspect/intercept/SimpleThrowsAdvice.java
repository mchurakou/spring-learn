package com.mikalai.spring.aspect.intercept;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleThrowsAdvice implements ThrowsAdvice {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        ErrorBean eb = new ErrorBean();
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(eb);
        pf.addAdvice(new SimpleThrowsAdvice());
        ErrorBean b = (ErrorBean)pf.getProxy();
        try{
            b.errorOne();
        } catch (Exception e){
            
        }
        
        try{
            b.errorTwo();

        } catch (Exception e){
            
        }
       
        
    }
    
    public void afterThrowing(Exception e){
        System.out.println("Exception: " + e.getMessage());
    }
    
    public void afterThrowing(Method m, Object[] arg, Object target, IllegalArgumentException e){
        System.out.println("IllegalArgumentException: " + e.getMessage());
    }

}
