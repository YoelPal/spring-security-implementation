package com.yoel.springboot.app.springboot_crud.services;

import java.util.List;

import com.yoel.springboot.app.springboot_crud.entities.User;

public interface UserService {

    List<User> findAll();
    User findById(Long id);
    User save(User user);
    void deleteById(Long id);
    User update(Long id, User user);


}
