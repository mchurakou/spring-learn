package com.mikalai.spring.aspect.after;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import com.mikalai.spring.aspect.MessageWriter;
import com.mikalai.spring.aspect.before.SecureBean;
import com.mikalai.spring.aspect.before.SecurityAdvice;
import com.mikalai.spring.aspect.before.SecurityManager;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {

    public void afterReturning(Object val, Method m, Object[] arg2,
            Object target) throws Throwable {
        
        System.out.println("\nAfter method:" + m.getName());

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleAfterReturningAdvice());
        pf.setTarget(target);
        
        MessageWriter proxy = (MessageWriter) pf.getProxy();
        proxy.writeMessage();


    }

}
