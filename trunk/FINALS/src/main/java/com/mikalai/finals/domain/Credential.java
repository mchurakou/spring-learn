package com.mikalai.finals.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Credential implements Serializable {
    private String login;
    private String password;
    
    public Credential() {
       
    }
    public Credential(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String toString(){
        return "login=" + login + "; password=" + password;
    }
    

}
