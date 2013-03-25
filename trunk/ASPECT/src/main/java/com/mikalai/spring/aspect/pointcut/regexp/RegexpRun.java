package com.mikalai.spring.aspect.pointcut.regexp;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

import com.mikalai.spring.aspect.pointcut.SimpleAdvice;
import com.mikalai.spring.aspect.pointcut.dynamic.SampleBean;

public class RegexpRun {

    /**
     * @param args
     */
    public static void main(String[] args) {
       SampleBean target = new SampleBean();
        
        JdkRegexpMethodPointcut pc = new JdkRegexpMethodPointcut();
        pc.setPattern(".*bar.*");


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
