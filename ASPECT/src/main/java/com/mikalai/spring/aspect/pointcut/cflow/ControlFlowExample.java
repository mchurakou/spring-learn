package com.mikalai.spring.aspect.pointcut.cflow;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ControlFlowExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ControlFlowExample ex = new ControlFlowExample();
        ex.run();
    }
    
    public void run(){
        TestBean target = new TestBean();
        
        Pointcut pc = new ControlFlowPointcut(ControlFlowExample.class,"test");
        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleBeforeAdvice());
        
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        
        TestBean proxy = (TestBean) pf.getProxy();
        
        proxy.foo();
        
        test(proxy);
    }
    
    public void test(TestBean bean){
        bean.foo();
    }

}
