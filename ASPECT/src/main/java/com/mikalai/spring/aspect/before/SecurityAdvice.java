package com.mikalai.spring.aspect.before;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SecurityAdvice implements MethodBeforeAdvice {
    private SecurityManager securityManager;
    public SecurityAdvice(){
        securityManager = new SecurityManager();
    }

    public void before(Method arg0, Object[] arg1, Object arg2)
            throws Throwable {
        UserInfo user = securityManager.getLoggedUser();
        if(user == null){
            System.out.println("No user");
            throw new SecurityException("Please login before");
        } else if ("clarence".equals(user.getUserName())){
            System.out.println("User ok");
        } else {
            System.out.println("Bad user");
            throw new SecurityException("Bad user");
        }

    }

}
