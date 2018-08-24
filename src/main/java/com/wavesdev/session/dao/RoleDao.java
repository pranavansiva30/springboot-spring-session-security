package com.wavesdev.session.dao;


import com.wavesdev.session.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pranavan on 3/20/18.
 */
public interface RoleDao  extends JpaRepository<Role, Long> {
}
