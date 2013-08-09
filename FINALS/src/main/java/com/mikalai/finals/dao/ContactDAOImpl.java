package com.mikalai.finals.dao;

import java.util.List;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import com.mikalai.finals.domain.Hobby;


@Repository("contactDAO")
@Transactional
public class ContactDAOImpl implements ContactDAO {

    private Log log = LogFactory.getLog(ContactDAOImpl.class);
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    @Override
    public List<Hobby> getAllHobbies() {
        log.info("Entered in ContactDAOImpl.getAllHobbies()");
        List<Hobby> hobbies = sessionFactory.getCurrentSession().createQuery("FROM Hobby h").list();
        log.info("Retrived count of hobbies= " + hobbies.size());
        return hobbies;
    }


}
