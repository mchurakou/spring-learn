package com.mikalai.spring.aspect.before;

public class SecurityManager {
    private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<UserInfo>();
    public void login(String userName, String password){
        threadLocal.set(new UserInfo(userName, password));
    }
    
    public void logout(){
        threadLocal.set(null);
    }
    
    public UserInfo getLoggedUser(){
        return threadLocal.get();
    }
}
