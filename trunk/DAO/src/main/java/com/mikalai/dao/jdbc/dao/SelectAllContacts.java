package com.mikalai.dao.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.object.MappingSqlQuery;

import com.mikalai.dao.jdbc.bean.Contact;
import javax.sql.DataSource;

public class SelectAllContacts extends MappingSqlQuery<Contact> {

    private static final String SQl_SELECT_ALL_CONTACT = "select id, first_name, last_name, birth_date from contact";
    
    public SelectAllContacts(DataSource ds){
        super(ds, SQl_SELECT_ALL_CONTACT);
    }
    
    @Override
    protected Contact mapRow(ResultSet rs, int i) throws SQLException {
        Contact contact = new Contact();
        contact.setId(rs.getLong("id"));
        contact.setFirstName(rs.getString("first_name"));
        contact.setLastName(rs.getString("last_name"));
        contact.setBirthDate(rs.getDate("birth_date"));
        return contact;
    }

}
