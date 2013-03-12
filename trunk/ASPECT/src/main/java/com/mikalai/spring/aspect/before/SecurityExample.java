package com.mikalai.spring.aspect.before;

import org.springframework.aop.framework.ProxyFactory;

import com.mikalai.spring.aspect.MessageWriter;

public class SecurityExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
       SecurityManager sm = new SecurityManager();
       
       SecureBean target = new SecureBean();
       ProxyFactory pf = new ProxyFactory();
       pf.addAdvice(new SecurityAdvice());
       pf.setTarget(target);
       SecureBean bean = (SecureBean) pf.getProxy();

       
       
       
       sm.login("clarence", "pas");
       bean.writeSecureMessage();
       sm.logout();
       
  

    }

}
