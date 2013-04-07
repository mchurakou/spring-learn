package com.mikalai.spring.aspect.aspectj;

import org.springframework.stereotype.Component;


@Component("myDependency")
public class MyDependency {

    public void foo(int val){
        System.out.println("foo:" + val);
    }
    
    public void bar(){
        System.out.println("bar:");
    }
}
