package com.wavesdev.session.service.impl;

import com.wavesdev.session.dao.RoleDao;
import com.wavesdev.session.model.Role;
import com.wavesdev.session.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pranavan on 3/20/18.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Override
    public Role findOne(Long id) {
        return roleDao.findOne(id);
    }

    @Override
    public Role saveRole(Role role) {
        return roleDao.save(role);
    }
    @Override
    public void deleteRole(Long id) {
        roleDao.delete(id);
    }

    @Override
    public List<Role> roleList() {
        return roleDao.findAll();
    }
}
