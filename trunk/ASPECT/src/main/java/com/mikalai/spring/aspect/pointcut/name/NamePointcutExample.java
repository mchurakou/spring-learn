package com.mikalai.spring.aspect.pointcut.name;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import com.mikalai.spring.aspect.pointcut.SimpleAdvice;
import com.mikalai.spring.aspect.pointcut.dynamic.SampleBean;
import com.mikalai.spring.aspect.pointcut.dynamic.SimpleDynamicPointcut;

public class NamePointcutExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SampleBean target = new SampleBean();
        
        NameMatchMethodPointcut pc = new NameMatchMethodPointcut();
        pc.addMethodName("foo");
        

        Advisor advisor = new DefaultPointcutAdvisor(pc,new SimpleAdvice());
        
        
        
        SampleBean proxy;

        

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        
        pf.setTarget(target);
        
        proxy = (SampleBean)pf.getProxy();
        
        
       proxy.foo(1);

       proxy.bar();

    }

}
