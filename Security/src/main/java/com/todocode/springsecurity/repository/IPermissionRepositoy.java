package com.todocode.springsecurity.repository;

import com.todocode.springsecurity.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPermissionRepositoy  extends JpaRepository<Permission, Long> {
}
