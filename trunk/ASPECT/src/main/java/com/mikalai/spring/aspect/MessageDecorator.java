package com.mikalai.spring.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageDecorator implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
       System.out.print("Hello ");
       Object val = invocation.proceed();
       System.out.println("!");
       return val;
       
    }

}
