package com.mikalai.spring.aspect.pointcut;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Before:" + invocation.getMethod().getName());
        Object r = invocation.proceed();
        System.out.println("Done");
        return r;
    }

}
