package com.todocode.springsecurity.service;

import com.todocode.springsecurity.model.Permission;
import com.todocode.springsecurity.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService implements IPermissionService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List findAll() {
        return List.of();
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Permission save(Permission permission) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Permission update(Permission permission) {
        return null;
    }
}
