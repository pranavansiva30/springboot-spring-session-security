package com.wavesdev.session.dao;


import com.wavesdev.session.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by pranavan on 3/20/18.
 */
public interface UserDao extends JpaRepository<User, Long> {

    @Query("FROM User WHERE userName=:username")
    User findByUsername(@Param("username") String username);
}
