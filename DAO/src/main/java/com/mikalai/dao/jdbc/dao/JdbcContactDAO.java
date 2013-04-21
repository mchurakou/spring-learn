package com.mikalai.dao.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mikalai.dao.jdbc.bean.Contact;

public class JdbcContactDAO implements ContactDAO {
    
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
        
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Contact> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Contact> findByFirstName(String firstName) {
        // TODO Auto-generated method stub
        return null;
    }

    public void insert(Contact contact) {
        // TODO Auto-generated method stub

    }

    public void update(Contact contact) {
        // TODO Auto-generated method stub

    }

    public void delete(Long contactID) {
        // TODO Auto-generated method stub

    }

    public String findFirstNamebyId(Long id) {
        String firstName = jdbcTemplate.queryForObject("select first_name from contact where id = ?", new Object[]{id}, String.class);
        return firstName;
    }


}
