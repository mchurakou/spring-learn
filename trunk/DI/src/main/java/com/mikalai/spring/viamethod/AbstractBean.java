package com.mikalai.spring.viamethod;

public abstract class AbstractBean implements DemoBean {

    @Override
    public abstract MyHelper getMyHelper();

    @Override
    public void exec() {
        getMyHelper().doing();
    }

 

}
