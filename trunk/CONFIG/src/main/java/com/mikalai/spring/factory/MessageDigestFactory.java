package com.mikalai.spring.factory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestFactory {

    private String algoritm = "MD5";
    
    public MessageDigest createInstance() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(algoritm);
    }
    public String getAlgoritm() {
        return algoritm;
    }
    public void setAlgoritm(String algoritm) {
        this.algoritm = algoritm;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
      
            GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
            ctx.load("classpath:factory.xml");
            ctx.refresh();      

            MessageDigester digester = (MessageDigester) ctx.getBean("digester");
            digester.digest("Hello World!");

       

    }

}
