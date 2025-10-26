package com.yoel.springboot.app.springboot_crud.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.yoel.springboot.app.springboot_crud.services.GenericService;

public abstract class GenericController<T> {

    private final GenericService <T> genericService;

    protected GenericController(GenericService<T> genericService) {
        this.genericService = genericService;
    }


    public ResponseEntity<List<T>> getAllEntity(){
        List<T> lista = genericService.findAll();
        return ResponseEntity.ok(lista);
    }
    public ResponseEntity<T> getEntityById(Long id){
        Optional<T> productOpt = genericService.findById(id);
        return productOpt.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    public ResponseEntity<T> createProduct(T entity){
         T entityT = genericService.save(entity);
         return ResponseEntity.ok(entityT);
    
    }
    public ResponseEntity<Void> deleteEntity(Long id){
        Optional<T> entityOpt = genericService.findById(id);
        if(entityOpt.isPresent()){
            genericService.delete(entityOpt.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

}
