package com.mikalai.finals.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mikalai.finals.dao.UserDAO;
import com.mikalai.finals.domain.Role;
import com.mikalai.finals.domain.User;





@Service("userAuthService") 
@Transactional
public class UserAuthService implements UserDetailsService {
    
    @Autowired
    private UserDAO userDAO;


    @Override
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
       
        User user = userDAO.getUserByLogin(login);
        if (user == null)
            throw new UsernameNotFoundException("user not found");

        return buildUserDetails(user);
    }
    
    
    public UserDetails buildUserDetails(User user) {

        String username = user.getCredential().getLogin();
        String password = user.getCredential().getPassword();
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        for (Role role : user.getRoles()) {
          authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        org.springframework.security.core.userdetails.User result = new org.springframework.security.core.userdetails.User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        return result;
    }
    
    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

}
