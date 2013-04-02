package com.mikalai.spring.aspect.introduction;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

public class IntroductionExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TargetBean target = new TargetBean();
        target.setName("Clarence");
        
        IntroductionAdvisor advisor = new IsModifiedAdvisor();
        
        ProxyFactory pf = new ProxyFactory();
        
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setOptimize(true);
        
        TargetBean proxy = (TargetBean) pf.getProxy();
        IsModified proxyInterface = (IsModified) proxy;
        
        System.out.println("Is TargetBean: " + (proxy instanceof TargetBean));
        System.out.println("Is IsModified: " + (proxy instanceof IsModified));
        
        System.out.println("Modified " + proxyInterface.isModified());
        
        proxy.setName("FDF");
        
        System.out.println("Modified " + proxyInterface.isModified());
        

    }

}
