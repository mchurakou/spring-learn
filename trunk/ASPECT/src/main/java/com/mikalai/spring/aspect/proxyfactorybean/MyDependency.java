package com.mikalai.spring.aspect.proxyfactorybean;

public class MyDependency {

   public void foo(int val){
       System.out.println("foo=" + val);
   }
   
   public void bar(){
       System.out.println("bar");
   }
}
