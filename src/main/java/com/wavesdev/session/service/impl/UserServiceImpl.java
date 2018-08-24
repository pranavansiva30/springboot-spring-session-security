package com.wavesdev.session.service.impl;

import com.wavesdev.session.dao.UserDao;
import com.wavesdev.session.model.Role;
import com.wavesdev.session.model.User;
import com.wavesdev.session.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pranavan on 3/20/18.
 */
@Service
public class UserServiceImpl implements UserService ,UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public List<User> userList() {
        return userDao.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userDao.findOne(id);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        User entity = userDao.findOne(user.getId());
        if(entity!=null){
            entity.setUsername(user.getUsername());
            if(!user.getPassword().equals(entity.getPassword())){
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setEmail(user.getEmail());
            entity.setRoles(user.getRoles());
            entity.setPasswordHint(user.getPasswordHint());
            entity.setActive(user.isActive());
            userDao.save(entity);
        }
        return entity;
    }

    @Override
    public User resetPassword(User user) {
        User entity = userDao.findOne(user.getId());
        if (entity != null) {
            if (!user.getPassword().equals(entity.getPassword())) {
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            userDao.save(entity);
        }
        return entity;
    }

    @Override
    public void deleteUser(Long id) {
        userDao.delete(id);
    }


    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        User user = userDao.findByUsername(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());

        return buildUserForAuthentication(user, authorities);


    }

    // Converts com.wavesdev.web.model.User user to
    // org.springframework.security.core.userdetails.User
    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isActive(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (Role userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

    @Override
    public User findByUsername(String username) {

        User user = userDao.findByUsername(username);
        return user;
    }
}
