package com.todocode.springsecurity.service;

import com.todocode.springsecurity.model.Role;

import java.util.List;
import java.util.Optional;

public class UserSecService implements IRoleService{
    @Override
    public List findAll() {
        return List.of();
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Role update(Role role) {
        return null;
    }
}
