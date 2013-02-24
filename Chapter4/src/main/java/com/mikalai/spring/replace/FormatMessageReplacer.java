package com.mikalai.spring.replace;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class FormatMessageReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object o, Method m, Object[] args)
            throws Throwable {
        if (isFormatMessageMethod(m)){
            String msg = (String) args[0];
            return "<h2>" + msg + "</h2>";
        } else {
            throw new IllegalArgumentException("Unable reimplement " + m.getName());
        }
    }
    
    private boolean isFormatMessageMethod(Method method){
       if(method.getParameterTypes().length != 1){
           return false;
       }
       
       if(!"formatMessage".equals(method.getName())){
           return false;
       }
       
       if(method.getReturnType() != String.class){
           return false;
       }
       
       if (method.getParameterTypes()[0] != String.class)
           return false;
       return true;
    }

}
