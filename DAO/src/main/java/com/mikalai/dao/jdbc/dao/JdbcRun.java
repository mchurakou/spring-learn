package com.mikalai.dao.jdbc.dao;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcRun {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context.xml");
        ctx.refresh();
        
        ContactDAO contactDAO = ctx.getBean("contactDAO", ContactDAO.class);
        System.out.println("NAME:" + contactDAO.findFirstNamebyId(1l));
    }

}
