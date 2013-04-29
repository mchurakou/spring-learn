package com.mikalai.dao.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mikalai.dao.jdbc.bean.Contact;
import com.mikalai.dao.jdbc.bean.ContactTelDetail;



@Repository("contactDAO")
public class JdbcContacAnnotationDAO implements ContactDAO {
    private Log log = LogFactory.getLog(JdbcContacAnnotationDAO.class);
    
    private DataSource dataSource;
    private SelectAllContacts selectAllContacts;
    private SelectContactByFirstName selectContactByFirstNam;
    private UpdateContact updateContact;
    private InsertContact insertContact;
    private InsertContactTelDetail insertContactTelDetail;
    private SfFirstNameById sfFirstNameById;
    
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
        this.updateContact = new UpdateContact(dataSource);
        this.insertContact = new InsertContact(dataSource);
        this.sfFirstNameById = new SfFirstNameById(dataSource);
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
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("first_name", contact.getFirstName());
        param.put("last_name", contact.getLastName());
        param.put("birth_date", contact.getBirthDate());
        
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertContact.updateByNamedParam(param, keyHolder);
        contact.setId(keyHolder.getKey().longValue());
        log.info("New contact:" + contact.getId());

    }

    @Override
    public void update(Contact contact) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("first_name", contact.getFirstName());
        param.put("last_name", contact.getLastName());
        param.put("birth_date", contact.getBirthDate());
        param.put("id", contact.getId());
        updateContact.updateByNamedParam(param);
        log.info("Contact was updated: " + contact.getId());

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
    public void insertWithDetail(Contact contact) {
        insertContactTelDetail = new InsertContactTelDetail(dataSource);
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("first_name", contact.getFirstName());
        param.put("last_name", contact.getLastName());
        param.put("birth_date", contact.getBirthDate());
        
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        insertContact.updateByNamedParam(param, keyHolder);
        contact.setId(keyHolder.getKey().longValue());
        log.info("New contact: " + contact.getId());
        
        List<ContactTelDetail> list = contact.getContactTelDetails();
        if (list !=  null) {
            for (ContactTelDetail ctd : list){
                param = new HashMap<String, Object>();
                param.put("contact_id", contact.getId());
                param.put("tel_type",ctd.getTelType());
                param.put("tel_number", ctd.getTelNumnber());
                insertContactTelDetail.updateByNamedParam(param);
            }
        }
        
        insertContactTelDetail.flush();

        
    }
    
    public List<Contact> findAllWithDetail() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String sql = "select c.id, c.first_name, c.last_name, c.birth_date" + 
                 ", t.id as contact_tel_id, t.tel_type, t.tel_number from contact c " + 
                 "left join contact_tel_detail t on c.id = t.contact_id";
        return jdbcTemplate.query(sql, new ContactWithDetailExtractor());
    }
    
    private static final class ContactWithDetailExtractor implements ResultSetExtractor<List<Contact>> {

        public List<Contact> extractData(ResultSet rs) throws SQLException,
                DataAccessException {

            Map<Long, Contact> map = new HashMap<Long, Contact>();
            Contact contact = null;
            while (rs.next()) {
                Long id = rs.getLong("id");
                contact = map.get(id);
                if (contact == null) {  // new contact record
                    contact = new Contact();
                    contact.setId(id);
                    contact.setFirstName(rs.getString("first_name"));
                    contact.setLastName(rs.getString("last_name"));
                    contact.setBirthDate(rs.getDate("birth_date"));
                    contact.setContactTelDetails(new ArrayList<ContactTelDetail>());
                    map.put(id, contact);
                }
                // Process contact tel. detail (if exists)
                Long contactTelDetailId = rs.getLong("contact_tel_id");
                if (contactTelDetailId > 0) {
                    ContactTelDetail contactTelDetail = new ContactTelDetail();
                    contactTelDetail.setId(contactTelDetailId);
                    contactTelDetail.setContactId(id);
                    contactTelDetail.setTelType(rs.getString("tel_type"));
                    contactTelDetail.setTelNumber(rs.getString("tel_number"));
                    contact.getContactTelDetails().add(contactTelDetail);
                }
            }
            
            return new ArrayList<Contact> (map.values());
        }
        
    }

    @Override
    public String sfFindFirstNamebyId(Long id) {
        List<String> result = sfFirstNameById.execute(id);
        return result.get(0);
    }   

}
