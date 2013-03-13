package com.mikalai.spring.aspect.instead;

public class WorkerBean {
    public void doSomeWork(int time){
        for (int x = 0; x < time; x++){
            work();
        }
    }
    
    private void work(){
        System.out.println("");
    }
}   
