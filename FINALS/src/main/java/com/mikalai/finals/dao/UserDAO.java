package com.mikalai.finals.dao;



import java.util.List;

import com.mikalai.finals.domain.User;




public interface UserDAO {
    User getUserByLogin(String login);
    User getUserById(long id);
    User saveUser(User user);
    boolean deleteUser(long id);
    List<User> getAllUsers();

}
