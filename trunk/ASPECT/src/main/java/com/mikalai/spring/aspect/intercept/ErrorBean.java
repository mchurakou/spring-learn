package com.mikalai.spring.aspect.intercept;

public class ErrorBean {
    public void errorOne() throws Exception{
        throw new Exception("Er1");
    }
    
    public void errorTwo() throws IllegalArgumentException{
        throw new IllegalArgumentException("Er2");
    }
}
