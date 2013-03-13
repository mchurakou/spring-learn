package com.mikalai.spring.aspect.instead;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.util.StopWatch;

import com.mikalai.spring.aspect.MessageWriter;
import com.mikalai.spring.aspect.after.SimpleAfterReturningAdvice;

public class ProfilingInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Begin");
        StopWatch sw = new StopWatch();
        sw.start(invocation.getMethod().getName());
        Object r = invocation.proceed();
        sw.stop();
        System.out.println("Time=" + sw.getTotalTimeMillis());
        return r;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        WorkerBean target = new WorkerBean();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new ProfilingInterceptor());
        pf.setTarget(target);
        
        WorkerBean proxy = (WorkerBean) pf.getProxy();
        proxy.doSomeWork(100);

    }

}
