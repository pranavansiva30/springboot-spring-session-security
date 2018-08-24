package com.wavesdev.session.service;

import com.wavesdev.session.model.Role;

import java.util.List;

/**
 * Created by pranavan on 3/20/18.
 */


public interface RoleService {

    public Role findOne(Long id);

    public Role saveRole(Role role);
    public void deleteRole(Long id);

    public List<Role> roleList();


}
