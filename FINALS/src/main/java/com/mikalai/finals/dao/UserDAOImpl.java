package com.mikalai.finals.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mikalai.finals.domain.User;




@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;
    
    public User getUserByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User WHERE login = :login");
        query.setParameter("login", login);
        User user = (User) query.uniqueResult();
        return user;
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

 
    public User getUserById(long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class,id);
      //  user.getRoles();
        return user;
    }

   
    public User saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        return user;
    }

    @Override
    public boolean deleteUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM User WHERE id = :id");
        query.setParameter("id", id);
        int count = query.executeUpdate();
        return count == 1;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User");
        List<User> result = query.list();
        return result;
    }

}
