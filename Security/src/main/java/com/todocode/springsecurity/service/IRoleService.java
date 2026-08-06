package com.todocode.springsecurity.service;

import com.todocode.springsecurity.model.Permission;
import com.todocode.springsecurity.model.Role;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IRoleService {


    List <Role> findAll();

    Optional <Role>findById(Long id);

    Role save(Role role);

    void deleteById(Long id);

    Role update(Role role);
    Role updatePermissions (Long id, Set<Permission> permissionsList);

}
