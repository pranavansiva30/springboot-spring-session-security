package com.wavesdev.session.service;


import com.wavesdev.session.model.User;

import java.util.List;

/**
 * Created by pranavan on 3/20/18.
 */
public interface UserService {

   public List<User> userList();

    public User findOne(Long id);

    public User saveUser(User user);
    public User updateUser(User user);
    public User resetPassword(User user);

    public void deleteUser(Long id);
    public User findByUsername(String username);


}
