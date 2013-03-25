package com.mikalai.spring.aspect.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

    public boolean matches(Method method, Class<?> targetClass) {
       return ("foo".equals(method.getName()));

    }
    
    public ClassFilter getClassFilter(){
        return new ClassFilter(){
            public boolean matches(Class<?> cls){
                return cls == BeanOne.class;
            }
        };
    }

}
