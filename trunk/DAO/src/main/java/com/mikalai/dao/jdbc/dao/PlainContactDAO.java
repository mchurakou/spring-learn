package com.mikalai.dao.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.mikalai.dao.jdbc.bean.Contact;

public class PlainContactDAO implements ContactDAO {
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/springDB", "user", "password");
    }
    
    private void closeConnection(Connection conncetion){
        if (conncetion == null) return;
        try {
            conncetion.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Contact> findAll() {
        List<Contact> result = new ArrayList<Contact>();
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from contact");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Contact contact = new Contact();
                contact.setId(rs.getLong("id"));
                contact.setFirstName(rs.getString("first_name"));
                contact.setLastName(rs.getString("last_name"));
                contact.setBirthDate(rs.getDate("birth_date"));
                result.add(contact);
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            closeConnection(connection);
        }
        return result;
    }

    public List<Contact> findByFirstName(String firstName) {
        return null;
    }

    public void insert(Contact contact) {
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into contact(first_name,last_name, birth_date) " +
            		"values(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, contact.getFirstName());
            ps.setString(2, contact.getLastName());
            ps.setDate(3,  new java.sql.Date(contact.getBirthDate().getTime()) );
            ps.execute();
            
            ResultSet generateKeys = ps.getGeneratedKeys();
            if (generateKeys.next()){
                contact.setId(generateKeys.getLong(1));
            }

        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            closeConnection(connection);
        }
    }

    public void update(Contact contact) {
        // TODO Auto-generated method stub

    }

    public void delete(Long contactID) {
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from contact where id = ?");
            ps.setLong(1, contactID);
            ps.execute();
          
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            closeConnection(connection);
        }

    }

    public String findFirstNamebyId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

	@Override
	public String findLastNamebyId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
