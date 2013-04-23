package com.mikalai.dao.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.mikalai.dao.jdbc.bean.Contact;

public class JdbcContactDAO implements ContactDAO {
    
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterjdbcTemplate;
    
    public DataSource getDataSource() {
        return dataSource;
        
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterjdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Contact> findAll() {
    	String sql = "select id, first_name, last_name, birth_date from contact";
        return jdbcTemplate.query(sql, new ContactMapper());
    }
    
    private static final class ContactMapper implements RowMapper<Contact>{
		public Contact mapRow(ResultSet rs, int i) throws SQLException {
			Contact contact = new Contact();
			contact.setId(rs.getLong("id"));
            contact.setFirstName(rs.getString("first_name"));
            contact.setLastName(rs.getString("last_name"));
            contact.setBirthDate(rs.getDate("birth_date"));
			return contact;
		}
    	
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

	@Override
	public String findLastNamebyId(Long id) {
		String sql = "select last_name from contact where id = :contactId";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("contactId", id);
		String lastName = namedParameterjdbcTemplate.queryForObject(sql, param, String.class);
        return lastName;
	}


}
