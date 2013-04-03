package com.mikalai.spring.aspect.proxyfactorybean;

public class MyBean {

   private MyDependency dep;
   
   public void execute(){
       dep.foo(100);
       dep.foo(101);
       dep.bar();
   }

    public MyDependency getDep() {
        return dep;
    }
    
    public void setDep(MyDependency dep) {
        this.dep = dep;
    }

}
