package com.mikalai.spring.aspect.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution (* com.mikalai.spring.aspect.aspectj..foo*(int)) && args(val)")
    public void fooExecution(int val){
        
    }
    
    @Pointcut("bean(myDependency)")
    public void inMyDependency(){
        
    }
    
    @Before("fooExecution(val) && inMyDependency()")
    public void simpleBeforeAdvice(JoinPoint jp, int val){
        if (val != 100){
            System.out.println("NEQ 100");
        }
    }
    
    
    @Around("fooExecution(val) && inMyDependency()")
    public Object simpleAroundAdvice(ProceedingJoinPoint pjp, int val) throws Throwable{
        System.out.println("Before");
        Object ret = pjp.proceed();
        System.out.println("After");
        return ret;
    }

}
