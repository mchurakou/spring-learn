package com.mikalai.spring.aspect.pointcut.dynamic;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.mikalai.spring.aspect.pointcut.BeanOne;
import com.mikalai.spring.aspect.pointcut.BeanTwo;
import com.mikalai.spring.aspect.pointcut.SimpleAdvice;
import com.mikalai.spring.aspect.pointcut.SimpleStaticPointcut;

public class DynamicPointcutExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SampleBean target = new SampleBean();

        Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointcut(),new SimpleAdvice());
        
        
        
        SampleBean proxy;

        

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        
        pf.setTarget(target);
        
        proxy = (SampleBean)pf.getProxy();
        
        
       proxy.foo(1);
       proxy.foo(10);
       proxy.foo(100);
       
       proxy.bar();
       proxy.bar();
       proxy.bar();

    }

}
