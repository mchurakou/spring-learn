package com.mikalai.dao.jdbc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mikalai.dao.jdbc.bean.Contact;



@Repository("contactDAO")
public class JdbcContacAnnotationDAO implements ContactDAO {
    private Log log = LogFactory.getLog(JdbcContacAnnotationDAO.class);
    
    private DataSource dataSource;
    private SelectAllContacts selectAllContacts;
    private SelectContactByFirstName selectContactByFirstNam;
    
    public Log getLog() {
        return log;
    }

    
    public void setLog(Log log) {
        this.log = log;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Resource(name="dataSource")
    public void setDatasource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllContacts = new SelectAllContacts(dataSource);
        this.selectContactByFirstNam = new SelectContactByFirstName(dataSource);
    }

    @Override
    public List<Contact> findAll() {
        return selectAllContacts.execute();
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        Map<String, Object> param = new HashMap<>();
        param.put("first_name", firstName);
        return selectContactByFirstNam.executeByNamedParam(param);
    }

    @Override
    public void insert(Contact contact) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Contact contact) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Long contactID) {
        // TODO Auto-generated method stub

    }

    @Override
    public String findFirstNamebyId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String findLastNamebyId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Contact> findAllWithDetail() {
        // TODO Auto-generated method stub
        return null;
    }

}
