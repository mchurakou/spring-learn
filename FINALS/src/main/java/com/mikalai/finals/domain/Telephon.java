package com.mikalai.finals.domain;



import java.io.Serializable;


public class Telephon implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String telType;
    private String telNumber;
    private int version;
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTelType() {
        return telType;
    }
    public void setTelType(String telType) {
        this.telType = telType;
    }
    public String getTelNumber() {
        return telNumber;
    }
    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    
    
    
}
