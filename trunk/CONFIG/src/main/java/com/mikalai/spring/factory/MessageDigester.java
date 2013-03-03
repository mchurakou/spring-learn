package com.mikalai.spring.factory;

import java.security.MessageDigest;

import org.springframework.context.support.GenericXmlApplicationContext;


public class MessageDigester {

    private MessageDigest digest1 = null;
    private MessageDigest digest2 = null;
    
    public void setDigest1(MessageDigest digest1) {
        this.digest1 = digest1;
    }
    
    public void setDigest2(MessageDigest digest2) {
        this.digest2 = digest2;
    }
    
    public void digest(String msg) {
        System.out.println("Using digest1");
        digest(msg, digest1);

        System.out.println("Using digest2");
        digest(msg, digest2);
    }
    
    private void digest(String msg, MessageDigest digest) {
        System.out.println("Using alogrithm: " + digest.getAlgorithm());
        digest.reset();
        byte[] bytes = msg.getBytes();
        byte[] out = digest.digest(bytes);
        System.out.println(out);
    }
    
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:factory.xml");
        ctx.refresh();      

        MessageDigester digester = (MessageDigester) ctx.getBean("digesterFactory");
        digester.digest("Hello World!");

    }
}
