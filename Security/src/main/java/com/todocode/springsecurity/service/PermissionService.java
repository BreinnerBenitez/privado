package com.todocode.springsecurity.service;

import com.todocode.springsecurity.model.Permission;
import com.todocode.springsecurity.repository.IPermissionRepositoy;
import com.todocode.springsecurity.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService implements IPermissionService {

    @Autowired
    private IPermissionRepositoy permissionRepositoy;

    @Override
    public List findAll() {
        return permissionRepositoy.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return  permissionRepositoy.findById(id);
    }

    @Override
    public Permission save(Permission permission) {
        return  permissionRepositoy.save(permission);
    }

    @Override
    public void deleteById(Long id) {

        permissionRepositoy.deleteById(id);
    }

    @Override
    public Permission update(Permission permission) {
        return permissionRepositoy.save(permission);
    }
}
