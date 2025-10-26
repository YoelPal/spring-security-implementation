package com.yoel.springboot.app.springboot_crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoel.springboot.app.springboot_crud.entities.Product;
import com.yoel.springboot.app.springboot_crud.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>)productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        Optional<Product> productOpt = productRepository.findById(product.getId());  
        productOpt.ifPresent(productRepository::delete); 
    }

}
