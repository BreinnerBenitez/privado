package com.todocode.springsecurity.service;

import com.todocode.springsecurity.model.UserSec;

import java.util.List;
import java.util.Optional;

public interface IUserSec {


    public List findAll();

    public Optional findById(Long id);

    public UserSec save(UserSec userSec);

    public void deleteById(Long id);

    public void update(UserSec userSec);


}
