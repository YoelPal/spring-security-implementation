package com.yoel.springboot.app.springboot_crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoel.springboot.app.springboot_crud.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
