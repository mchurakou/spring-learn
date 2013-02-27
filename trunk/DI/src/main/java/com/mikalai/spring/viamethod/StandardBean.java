package com.mikalai.spring.viamethod;

public class StandardBean implements DemoBean {

    private MyHelper myHelper;
    
    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }

    @Override
    public MyHelper getMyHelper() {
        return this.myHelper;
    }

    @Override
    public void exec() {
        myHelper.doing();

    }



}
