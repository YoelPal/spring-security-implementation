package com.yoel.springboot.app.springboot_crud.services;

import java.util.List;
import java.util.Optional;


public interface GenericService<T> {

    List<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void delete(T t);

}
