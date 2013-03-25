package com.mikalai.spring.aspect.pointcut.dynamic;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("Static check " + method.getName());
        return ("foo".equals(method.getName()));
    }
    
    public boolean matches(Method m, Class<?> cls, Object[] args){
        System.out.println("Dynamic check " + m.getName());
        int x = ((Integer) args[0]).intValue();
        return (x!=100);
    }
    
    public ClassFilter getClassFilter(){
        return new ClassFilter(){
          public boolean matches(Class<?> cls){
              return (cls == SampleBean.class);
          }
        };
    }

}
