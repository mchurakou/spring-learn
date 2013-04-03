package com.mikalai.spring.aspect.proxyfactorybean;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.MethodBeforeAdvice;

public class MyAdvice  {

    public void simpleBeforeAdvice(JoinPoint joinPoint, int val)
            throws Throwable {
        System.out.println("Exec " + joinPoint.getSignature().getDeclaringTypeName() + " " + joinPoint.getSignature().getName() + "val=" + val);

    }
    
    public Object simpleAround(ProceedingJoinPoint pjp, int val) throws Throwable{
        System.out.println("before " + pjp.getSignature().getName() + "arg=" + val);
        Object res = pjp.proceed();
        System.out.println("After" + pjp.getSignature().getName());
        return res;
    }

}
